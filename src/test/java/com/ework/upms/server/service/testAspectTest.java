package com.ework.upms.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class testAspectTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private TestAspect testAspect;
    @Autowired
    private TestWithoutAspect testWithoutAspect;

    @Test
    public void test() {
        testAspect.helloWorld();
        testWithoutAspect.helloWorld();
    }
}
