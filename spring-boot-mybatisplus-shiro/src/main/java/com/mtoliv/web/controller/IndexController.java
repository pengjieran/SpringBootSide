package com.mtoliv.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtoliv.entity.Account;

@RestController
@RequestMapping(value = "/api/v1")
public class IndexController {

	@PostMapping(value = "/login")
	public boolean login(@RequestBody Account account) {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(account.getUsername(), account.getPassword());
		try {
			
			subject.login(token);
			if (subject.isAuthenticated()) {
				
				return true;
			} else {
				
				return false;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
}