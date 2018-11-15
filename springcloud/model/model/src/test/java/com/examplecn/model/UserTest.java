package com.examplecn.model;

import org.junit.Assert;
import org.junit.Test;

import com.examplecn.model.User.UserBuilder;

public class UserTest {

	@Test
	public void userBuilder() {
		
		UserBuilder userBuilder = User.builder().username("123456").password("123456");
		Assert.assertEquals("123456", userBuilder.build().getUsername());
	}
}