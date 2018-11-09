package com.pengjieran.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pengjieran.model.Person;
import com.pengjieran.service.PersonService;

@RestController
public class PersonController implements PersonService {

	@Override
	public Person get(@RequestParam(value = "id", required = true) String id) {
		
		Person person = new Person();
		person.setId("123456");
		person.setName("123456");
		person.setSex(1);
		
		return person;
	}

}