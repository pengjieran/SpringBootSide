package com.examplecn.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {

    private String username;

    private String password;

    private String nickName;
}
