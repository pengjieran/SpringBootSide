package com.mtoliv.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtoliv.entity.Account;
import com.mtoliv.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2018-06-11
 */
@RestController
@RequestMapping("/api/v1/accounts")
@Api(tags = "账号相关接口")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增账号")
	public Account put(@RequestBody Account account) {
		
		accountService.insertOrUpdate(account);
		System.out.println(account.getId());
		return account;
	}
}