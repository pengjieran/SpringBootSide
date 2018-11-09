package com.pengjieran.client;

import com.pengjieran.model.Person;

public class PersonClientFallback implements PersonClient {

	private Throwable cause;
	
	public PersonClientFallback(Throwable cause) {
		this.cause = cause;
	}
	
	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public Person get(String id) {
		
		return new Person();
	}
}