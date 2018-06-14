package com.mtoliv.web.controller;

import java.io.Serializable;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mtoliv.entity.Token;
import com.mtoliv.entity.UserInfo;
import com.mtoliv.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1")
@Api(tags = "登录注册相关接口")
public class IndexController {
	
	@Autowired
	public UserInfoService userInfoService;
	
	@GetMapping(value = "/accounts/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "携带token请求账号信息")
	public List<UserInfo> list() {
		
		EntityWrapper<UserInfo> userInfoEntity = new EntityWrapper<>();
		return userInfoService.selectList(userInfoEntity);
	}
	
	@PostMapping(value = "/sign", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "用户注册")
	public UserInfo sign(@RequestBody UserInfo userInfo) {
		
		userInfoService.insert(userInfo);
		
		return userInfo;
	}

	@PostMapping(value = "/login")
	public Token login(@RequestBody UserInfo account) {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(account.getUsername(), account.getPassword());
		try {
			
			subject.login(token);
			if (subject.isAuthenticated()) {
				
				Serializable id = SecurityUtils.getSubject().getSession().getId();
				Token resultToken = new com.mtoliv.entity.Token();
				resultToken.setToken(id.toString());
				
				return resultToken;
			} else {
				
				return null;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
}