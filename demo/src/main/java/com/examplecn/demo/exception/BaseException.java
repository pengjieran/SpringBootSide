package com.examplecn.demo.exception;

/**
 * 异常基础类，所有自定义异常都继承此类
 */
public class BaseException extends Exception {

    protected int httpStatus;

    protected String errorCode;

    protected String devMessage;

    public BaseException(String message, String errorCode, String devMessage) {
        super(message);
        this.errorCode = errorCode;
        this.devMessage = devMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDevMessage() {
        return devMessage;
    }
}
