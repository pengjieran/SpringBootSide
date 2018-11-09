package com.pengjieran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengjieran.client.PersonClient;
import com.pengjieran.model.Person;
import com.pengjieran.model.User;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private PersonClient personClient;
	
    @GetMapping
    public User put() {
        
        User user = new User();
        user.setUsername("username");
        user.setPassword("123456");
        
        Person person = personClient.get("123456");
        user.setPerson(person);
        return user;
    }
}