package com.pengjieran.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examplecn.model.Person;
import com.pengjieran.service.PersonService;

@RestController
public class PersonController implements PersonService {

	@Override
	public Person get(@RequestParam(value = "id", required = true) String id) {
		
		 return Person.builder().age(30).name("123456").six(1).build();
	}

}