package com.pengjieran.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplecn.model.Person;
import com.examplecn.model.User;
import com.examplecn.model.User.UserBuilder;
import com.pengjieran.client.PersonClient;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private PersonClient personClient;
	
	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;
	
    @GetMapping
    public User put() {
    	
        UserBuilder userBuilder = User.builder();
        userBuilder.username("12345").password("123456");
        
        Person person = personClient.get("123456");
        userBuilder.person(person);
        redisTemplate.opsForValue().set("1", userBuilder.build());
        return userBuilder.build();
    }
}