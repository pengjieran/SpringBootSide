/*package com.pengjieran.client;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class PersonClientFallbackFactory implements FallbackFactory<PersonClient> {

	@Override
	public PersonClient create(Throwable cause) {
		
		return new PersonClientFallback(cause);
	}

}*/