package com.examplecn.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data//get/set
@Builder//构建器
@AllArgsConstructor//全参数构造器
public class Person implements Serializable {

	private static final long serialVersionUID = -4602205701641798622L;

	private String name;
	
	private Integer six;
	
	private Integer age;
}