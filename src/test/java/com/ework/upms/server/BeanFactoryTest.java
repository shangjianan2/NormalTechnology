package com.ework.upms.server;

import com.ework.upms.server.circle.CircleA;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.Test;
import test.customtag.User;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet2.xml"));
        TestObj test = (TestObj)bf.getBean("test");
        test.display();
    }

    @Test
    public void testSimpleLoad_constructor() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet2.xml"));
        TestObj test = (TestObj)bf.getBean("test_constructor");
        test.display();
    }

    @Test
    public void testCustomTag() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet2.xml"));
        User user = (User)bf.getBean("hhh");
        System.out.printf("userName:%s\r\n", user.getUserName());
        System.out.printf("email:%s\r\n", user.getEmail());
    }

    @Test
    public void testCircle() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet-circle.xml"));
        CircleA circleA = (CircleA)bf.getBean("circleA");
        circleA.display();
        circleA.getCircleB().display();
        circleA.getCircleC().display();
    }
}
