package com.ework.upms.server.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.ework.upms.server.controller.IndexController.hello(..))")
    public Object testAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("aspect pre");
        Object o = jp.proceed();
        System.out.println("aspect post");
        return o;
    }
}
