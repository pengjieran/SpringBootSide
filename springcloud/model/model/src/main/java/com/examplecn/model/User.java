package com.examplecn.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -3035251335348123124L;

	private String username;
	
	private String password;
}