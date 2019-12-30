package com.examplecn.demo.authentication.enumeration;

public enum AuthType implements ProvidedAuthType {

    ID_PASSWORD("idPasswordLoginAuthenticator");

    AuthType(String authenticator)
    {
        this.authenticator = authenticator;
    }

    private String  authenticator;

    public String getAuthenticator() {
        return authenticator;
    }

    public String getAuthType()
    {
        return this.name();
    }
}
