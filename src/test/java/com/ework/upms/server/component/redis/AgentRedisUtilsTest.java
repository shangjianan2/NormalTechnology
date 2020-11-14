package com.ework.upms.server.component.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class AgentRedisUtilsTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private AgentRedisUtils agentRedisUtils;

    public void test() {
        Assert.notNull(this.agentRedisUtils, "redisUtils 为空");
        System.out.println("hello world");
    }
}
