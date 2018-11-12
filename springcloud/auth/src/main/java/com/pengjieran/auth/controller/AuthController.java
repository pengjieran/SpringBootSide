package com.pengjieran.auth.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengjieran.auth.model.AuthBody;
import com.pengjieran.auth.model.LoginBody;

@RestController
@RequestMapping(value = "/*/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {


    @PostMapping(value = "/login")
    public AuthBody login(@RequestBody LoginBody loginBody) {

        return new AuthBody();
    }
}
