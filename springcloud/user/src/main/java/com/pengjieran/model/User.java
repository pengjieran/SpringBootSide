package com.pengjieran.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 2840391495169060928L;

    private String username;
    
    private String password;
    
    private Person person;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
}