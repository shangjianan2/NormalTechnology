package com.ework.upms.server.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestWithoutAspect {

    @Transactional(transactionManager = "adsTm")
    public String helloWorld() {
        return "adsf";
    }

}
