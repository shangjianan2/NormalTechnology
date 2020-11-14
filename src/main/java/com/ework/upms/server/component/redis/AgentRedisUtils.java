package com.ework.upms.server.component.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Component
public class AgentRedisUtils implements InitializingBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private Jedis jedis;
    @Value("${redis.ip}")
    private String jedisIp;

    public void afterPropertiesSet() throws Exception {
        logger.info("redis ip: {}", jedisIp);
        this.jedis = new Jedis(jedisIp);
        logger.info("连接成功");
        logger.info("服务正在运行: "+jedis.ping());
    }
}
