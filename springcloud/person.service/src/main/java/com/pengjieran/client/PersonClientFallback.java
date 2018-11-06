package com.pengjieran.client;

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
}