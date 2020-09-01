package com.ework.upms.server.post.processors;

import org.springframework.beans.factory.InitializingBean;

public class TestProcessor implements InitializingBean {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
    public void init(){
        System.out.println("Bean is going through init.");
    }
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + " afterPropertiesSet");
    }
}
