package com.ework.upms.server.component.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class AgentRedisUtils implements InitializingBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private Jedis jedis;
    @Value("${redis.ip}")
    private String jedisIp;

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 当key不存在时才set
     */
    private static final boolean SET_IF_NOT_EXIST = false;

    /**
     * 存活时间和单位
     */
    private static final long DEFAULT_TIMEOUT = 3L;
    private static final TimeUnit DEFAULT_TIMEOUT_UNIT = TimeUnit.MINUTES;

    private static String uniqueShaRelease = null;
    private static String uniqueShaTryGet = null;

    public void afterPropertiesSet() throws Exception {

    }


    /**
     * 先运行initUniqueSha，再运行afterPropertiesSet
     */
    @PostConstruct
    public void initUniqueSha() {
        logger.info("redis ip: {}", jedisIp);
        this.jedis = new Jedis(jedisIp);
        logger.info("连接成功");
        logger.info("服务正在运行: "+jedis.ping());

        logger.info("initUniqueSha begin");
        //释放锁
        String scriptRelease = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        AgentRedisUtils.uniqueShaRelease = this.jedis.scriptLoad(scriptRelease);

        //获取锁
        String scriptTryGet = "return redis.call('set', KEYS[1], ARGV[1], 'EX', ARGV[2], 'NX')";
        AgentRedisUtils.uniqueShaTryGet = this.jedis.scriptLoad(scriptTryGet);

        logger.info("initUniqueSha end, uniqueSha = {}", AgentRedisUtils.uniqueShaRelease);
    }

    public String getValue(String key) {
        return this.jedis.get(key);
    }

    /**
     * 尝试获取分布式锁
     * @param lockKey
     * @param requestId
     * @return
     */
    public boolean tryGetDistributeLock(String lockKey, String requestId) {
        return this.tryGetDistributeLock(lockKey, requestId, AgentRedisUtils.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }
    /**
     * 尝试获取分布式锁
     * @param lockKey
     * @param requestId
     * @param timeout
     * @param unit
     * @return 是否成功
     */
    public boolean tryGetDistributeLock(String lockKey, String requestId, long timeout, TimeUnit unit) {
        Object success = this.jedis.evalsha(AgentRedisUtils.uniqueShaTryGet, 1, lockKey, requestId, String.valueOf(timeout));
        logger.info("tryGetDistributeLock lockKey = {}, requestId = {}, timeout = {}, unit = {}, get success = {}", lockKey, requestId, timeout, unit, success);
        return "OK".equals(success);
    }

    /**
     * 释放锁
     * @param lockKey
     * @param requestId
     * @return
     */
    public boolean releaseDistributeLock(String lockKey, String requestId) {
        Object success = this.jedis.evalsha(AgentRedisUtils.uniqueShaRelease, 1, lockKey, requestId);
        logger.info("releaseDistributeLock lockKey = {}, requestId = {}, success = {}", lockKey, requestId, success);
        return RELEASE_SUCCESS.equals(success);
    }

    /**
     * 生成一个唯一的请求标识
     * @return
     */
    public String generateRequestId() {
        return UUID.randomUUID().toString();
    }
}
