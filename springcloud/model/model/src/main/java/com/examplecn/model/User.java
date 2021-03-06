package com.examplecn.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = -3035251335348123124L;

	private String username;
	
	private String password;
	
	private Person person;
}