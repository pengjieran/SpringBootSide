package com.pengjieran.auth.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengjieran.auth.model.AuthBody;
import com.pengjieran.auth.model.LoginBody;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {

	/**
	 * 登录
	 * @param loginBody
	 * @return
	 */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AuthBody login(@RequestBody LoginBody loginBody) {

        return new AuthBody();
    }
    
    /**
     * 注册
     * @param loginBody
     * @return
     */
    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AuthBody signup(@RequestBody LoginBody loginBody) {
    	
    	return new AuthBody();
    }
}
