package com.examplecn.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseModel implements Serializable {

    private String code;

    private String message;

    private Object data;

    public ResponseModel() {}

    public ResponseModel(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseModel success(Object data) {

        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode("200");
        responseModel.setMessage("操作成功");
        responseModel.setData(data);
        return responseModel;
    }
}
