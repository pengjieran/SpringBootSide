package com.pengjieran.auth.controller;

import com.pengjieran.auth.model.LoginBody;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/*/api/v1/auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {


    @PostMapping(value = "/login")
    public boolean login(@RequestBody LoginBody loginBody) {

        return true;
    }
}
