package com.pengjieran.config.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;

public class JWTTokenExtractException extends JWTVerificationException {

	private static final long serialVersionUID = -4141770449020276264L;

	public JWTTokenExtractException(String message) {
		super(message);
	}

}