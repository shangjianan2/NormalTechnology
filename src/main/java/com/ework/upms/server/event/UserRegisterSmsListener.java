package com.ework.upms.server.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserRegisterSmsListener{

    // 通过注解实现监听器
//    @Async
    @EventListener(UserDTO.class)
    public void handleUserEvent(UserDTO userDTO){
        System.out.println("监听到用户注册，准备发送短信，user:"+userDTO.toString());
    }
}
