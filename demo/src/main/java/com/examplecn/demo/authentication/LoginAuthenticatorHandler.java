package com.examplecn.demo.authentication;

import com.examplecn.demo.authentication.enumeration.IdType;
import com.examplecn.demo.authentication.enumeration.UserType;
import com.examplecn.demo.entity.Account;
import com.examplecn.demo.model.AuthModel;

public interface LoginAuthenticatorHandler {

    Account doAuthenticate(IdType idType, UserType userType, AuthModel authModel) throws Exception;
}
