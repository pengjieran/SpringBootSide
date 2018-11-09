package com.pengjieran.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pengjieran.model.Person;

public interface PersonService {

	@GetMapping(value = "/api/v1/persons", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Person get(@RequestParam(value = "id", required = true) String id);
}