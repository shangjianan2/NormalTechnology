package com.ework.upms.server.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserDTO extends ApplicationEvent {
    private Integer userId;
    private String name;
    private Integer age;

    public UserDTO(Object source, Integer userId, String name, Integer age) {
        super(source);
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}
