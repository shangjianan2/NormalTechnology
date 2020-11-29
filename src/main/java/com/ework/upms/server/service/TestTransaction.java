package com.ework.upms.server.service;

import com.ework.upms.server.annotation.MyAnnotation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransaction {

    @Transactional(transactionManager = "adsTm")
    public String helloWorld() {
        return "adsf";
    }

}
