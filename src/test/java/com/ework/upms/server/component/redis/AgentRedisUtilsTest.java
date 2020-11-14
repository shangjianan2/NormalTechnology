package com.ework.upms.server.component.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class AgentRedisUtilsTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private AgentRedisUtils agentRedisUtils;

    @Test
    public void test() {
        Assert.notNull(this.agentRedisUtils, "redisUtils 为空");
        System.out.println("hello world");
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
