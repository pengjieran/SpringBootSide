package com.pengjieran.auth.model;

import java.io.Serializable;

public class AuthBody implements Serializable {

	private static final long serialVersionUID = 412669827660442100L;

	private String type;

    private String body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
