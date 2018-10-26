package com.ambow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@TableName("t_organization")
public class Organization extends Model<Organization> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String code;
    /**
     * 管理员id
     */
    private String managerId;
    /**
     * 父节点id
     */
    private String pId;


    public String getId() {
        return id;
    }

    public Organization setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Organization setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Organization setCode(String code) {
        this.code = code;
        return this;
    }

    public String getManagerId() {
        return managerId;
    }

    public Organization setManagerId(String managerId) {
        this.managerId = managerId;
        return this;
    }

    public String getpId() {
        return pId;
    }

    public Organization setpId(String pId) {
        this.pId = pId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Organization{" +
        ", id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", managerId=" + managerId +
        ", pId=" + pId +
        "}";
    }
}
