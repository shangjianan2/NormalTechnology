package com.ework.upms.server;

import com.ework.upms.server.circle.CircleA;
import com.ework.upms.server.circle.CircleC;
import com.ework.upms.server.constructor.ccc;
import com.ework.upms.server.i18n.I18nTest;
import com.ework.upms.server.post.processors.TestProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.customtag.User;

import java.util.Locale;

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
//        CircleA circleA = (CircleA)bf.getBean("circleA");
//        circleA.display();
//        circleA.getCircleB().display();
//        circleA.getCircleC().display();
//        System.out.println(circleA);
        CircleC circleC = (CircleC)bf.getBean("circleC");
        System.out.println(circleC);
    }

    @Test
    public void testConstructor() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet-constructor.xml"));
        ccc ccc = (ccc)bf.getBean("ccc");
        System.out.println(ccc);

        ccc ccc1 = (ccc)bf.getBean("ccc1");
        System.out.println(ccc1);
    }

    @Test
    public void testPostProcessors() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet-processor.xml");
        TestProcessor testProcessor = (TestProcessor)context.getBean("testProcessor");
        testProcessor.getMessage();
    }

    @DataProvider(name = "testI18nData")
    public Object[][] testI18nData() {
        return new Object[][] {
                {Locale.US},
                {new Locale("in", "ID")},
                {Locale.CHINA}
        };
    }
    @Test(dataProvider = "testI18nData")
    public void testI18n(Locale locale) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet-i18n.xml");
        I18nTest i18nTest = (I18nTest)context.getBean("i18nTest");
        String s = i18nTest.getMessage("empty.request", null, locale);
        System.out.println(s);
    }
}
