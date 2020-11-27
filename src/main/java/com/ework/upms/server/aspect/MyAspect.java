package com.ework.upms.server.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Around("@annotation(com.ework.upms.server.annotation.MyAnnotation)")
    public Object testAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("aspect pre");
        Object o = jp.proceed();
        System.out.println("aspect post");
        return o;
    }
}
