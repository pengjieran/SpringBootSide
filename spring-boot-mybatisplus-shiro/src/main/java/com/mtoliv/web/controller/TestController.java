package com.mtoliv.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtoliv.entity.Account;
import com.mtoliv.service.AccountService;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public List<Account> get() {

		return accountService.list();
	}
}