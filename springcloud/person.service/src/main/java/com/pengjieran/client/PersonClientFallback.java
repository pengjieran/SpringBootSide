package com.pengjieran.client;

import org.springframework.stereotype.Component;

import com.pengjieran.model.Person;

@Component
public class PersonClientFallback implements PersonClient {

	@Override
	public Person get(String id) {
		
		return new Person();
	}
}