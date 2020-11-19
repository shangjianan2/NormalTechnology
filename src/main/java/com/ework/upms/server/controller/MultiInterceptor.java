package com.ework.upms.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MultiInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/a/a/a")
    @ResponseBody
    public String aaa() {
        return "aaa";
    }

    @RequestMapping("/a/a/b")
    @ResponseBody
    public String aab() {
        return "aab";
    }

    @RequestMapping("/a/b/b")
    @ResponseBody
    public String abb() {
        return "abb";
    }

    @RequestMapping("/b/a/a")
    @ResponseBody
    public String baa() {
        return "baa";
    }

    @RequestMapping("/b/a/b")
    @ResponseBody
    public String bab() {
        return "bab";
    }

    @RequestMapping("/b/b/b")
    @ResponseBody
    public String bbb() {
        return "bbb";
    }
}
