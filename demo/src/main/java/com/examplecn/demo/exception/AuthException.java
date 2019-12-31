package com.examplecn.demo.exception;


/**
 * @Description:
 * @author: Aaron
 * @date: 2019/12/31 16:07
 */
public class AuthException extends BaseException {

    public AuthException(String message) {
        super(message, AuthException.class.getSimpleName(), "权限认证失败.");
        this.httpStatus = 401;
    }
}
