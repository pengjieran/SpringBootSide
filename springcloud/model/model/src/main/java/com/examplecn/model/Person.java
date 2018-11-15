package com.examplecn.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable {

	private static final long serialVersionUID = -4602205701641798622L;

	private String name;
	
	private Integer six;
	
	private Integer age;
}
