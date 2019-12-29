package com.examplecn.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_user")
public class User implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "nick_name")
    private String nickName;
}
