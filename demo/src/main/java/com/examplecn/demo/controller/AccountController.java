package com.examplecn.demo.controller;

import com.examplecn.demo.model.ResponseModel;
import com.examplecn.demo.model.UserModel;
import com.examplecn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseModel register(@RequestBody UserModel userModel) {

        return userService.create(userModel);
    }

}
