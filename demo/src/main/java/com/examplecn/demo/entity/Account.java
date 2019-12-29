package com.examplecn.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_account")
public class Account implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String username;

    private String password;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "account_type")
    private int accountType;

    @TableLogic(value = "0", delval = "1")
    private int status;

    public static final String USERNAME = "username";
}
