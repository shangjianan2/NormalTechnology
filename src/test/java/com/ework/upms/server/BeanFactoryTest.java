package com.ework.upms.server;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet.xml"));
        TestObj test = (TestObj)bf.getBean("test");
        test.display();
    }
}
