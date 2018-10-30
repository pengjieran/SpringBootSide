package com.pengjieran.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengjieran.model.User;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @GetMapping
    public User put() {
        
        User user = new User();
        user.setUsername("username");
        user.setPassword("123456");
        return user;
    }
}