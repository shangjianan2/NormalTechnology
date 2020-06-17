package com.ework.upms.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","zhangsan");
        modelAndView.setViewName("hello");
        System.out.println("controller");
        return modelAndView;
    }
}
