package com.examplecn.demo.controller;

import com.examplecn.demo.authentication.IdPasswordLoginAuthenticator;
import com.examplecn.demo.authentication.LoginAuthenticator;
import com.examplecn.demo.authentication.enumeration.AuthType;
import com.examplecn.demo.authentication.enumeration.IdType;
import com.examplecn.demo.authentication.enumeration.ProvidedAuthType;
import com.examplecn.demo.authentication.enumeration.UserType;
import com.examplecn.demo.entity.Account;
import com.examplecn.demo.model.AuthModel;
import com.examplecn.demo.model.IdPasswordAuthModel;
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

    @Autowired
    private IdPasswordLoginAuthenticator loginAuthenticator;

    @PostMapping
    public ResponseModel register(@RequestBody UserModel userModel) throws Exception {

        return userService.create(userModel);
    }

    @PostMapping(value = "/login")
    public ResponseModel login(@RequestBody Account account) throws Exception {

        IdPasswordAuthModel authModel = new IdPasswordAuthModel();
        authModel.setLoginId(account.getUsername());
        authModel.setPassword(account.getPassword());

        Account responseAccount = loginAuthenticator.doAuthenticate(IdType.userName, UserType.PUBLIC, authModel);

        return ResponseModel.succeed(responseAccount);
    }

}
