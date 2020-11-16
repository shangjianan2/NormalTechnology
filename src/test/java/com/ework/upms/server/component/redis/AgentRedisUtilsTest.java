package com.ework.upms.server.component.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class AgentRedisUtilsTest extends AbstractTestNGSpringContextTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private AgentRedisUtils agentRedisUtils;

    /**
     * key相同时
     */
    @Test
    public void testSameKey() {
        Assert.notNull(this.agentRedisUtils, "redisUtils 为空");

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                task("thread", 1000L, "thread1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                task("thread", 2000L, "thread2");
            }
        });


        try {
            logger.info("thread2 start");
            thread2.start();
            Thread.sleep(500);
            logger.info("thread1 start");
            thread1.start();
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Over");
    }
    /**
     * key不同时
     */
    @Test
    public void testDiffKey() {
        Assert.notNull(this.agentRedisUtils, "redisUtils 为空");

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                task("thread1", 1000L, "thread1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                task("thread2", 2000L, "thread2");
            }
        });


        try {
            logger.info("thread2 start");
            thread2.start();
            Thread.sleep(500);
            logger.info("thread1 start");
            thread1.start();
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Over");
    }
    public void task(String lockKey, long delayTime, String name) {
        logger.info("入参 lockKey = {}, delayTime = {}", lockKey, delayTime);
        String key = DigestUtils.md5DigestAsHex(lockKey.getBytes());
        String requestId = this.agentRedisUtils.generateRequestId();
        if (!this.agentRedisUtils.tryGetDistributeLock(key, requestId)) {
            logger.info("{} 获取锁失败", name);
            return;
        }
        logger.info("{} 获取锁成功", name);
        try {
            Thread.sleep(delayTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.agentRedisUtils.releaseDistributeLock(key, requestId)) {
            logger.info("{} 释放锁失败", name);
            return;
        }
        logger.info("{} 释放锁成功", name);
    }

    @Test(dataProvider = "getValueData")
    public void getValueTest(String key) {
        String value = this.agentRedisUtils.getValue(key);
        System.out.println(value);
    }
    @DataProvider(name = "getValueData")
    public Object[][] getValueData() {
        return new Object[][] {
                {"test"}
        };
    }
}
