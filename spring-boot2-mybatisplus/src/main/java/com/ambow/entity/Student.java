package com.ambow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学生信息
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@TableName("t_student")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    /**
     * 所属学校
     */
    private String orgId;
    /**
     * 学生编码
     */
    private String code;


    public String getId() {
        return id;
    }

    public Student setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public Student setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Student setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
        ", id=" + id +
        ", name=" + name +
        ", orgId=" + orgId +
        ", code=" + code +
        "}";
    }
}
