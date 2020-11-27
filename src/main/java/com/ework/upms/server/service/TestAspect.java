package com.ework.upms.server.service;

import com.ework.upms.server.annotation.MyAnnotation;
import org.springframework.stereotype.Service;

@Service
public class TestAspect {
    @MyAnnotation
    public String helloWorld() {
        return "adsf";
    }

}
