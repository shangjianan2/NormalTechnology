package com.ework.upms.server.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Override
    public void register(){
        UserDTO userDTO = new UserDTO(this, 18, "精灵王jinglingwang.cn", 1001);
//        userDTO.setAge(18);
//        userDTO.setName("精灵王jinglingwang.cn");
//        userDTO.setUserId(1001);
        System.out.println("register user");
        eventPublisher.publishEvent(userDTO);
    }
}
