package com.examplecn.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @author: Aaron
 * @date: 2019/12/30 19:14
 */
@Data
public class AuthModel implements Serializable {

    private static final long serialVersionUID = 326567545234532L;

    private String loginId;
}
