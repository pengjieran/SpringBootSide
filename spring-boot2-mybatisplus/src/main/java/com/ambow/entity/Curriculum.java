package com.ambow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 课程信息
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@TableName("t_curriculum")
public class Curriculum extends Model<Curriculum> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程主键
     */
    private String id;
    /**
     * 课程名
     */
    private String name;
    /**
     * 课程编码
     */
    private String code;
    /**
     * 所属学校
     */
    private String orgId;
    /**
     * 课程开始时间
     */
    private LocalDateTime startTime;
    /**
     * 课程结束时间
     */
    private LocalDateTime endTime;
    /**
     * 默认教师
     */
    private String teacherId;


    public String getId() {
        return id;
    }

    public Curriculum setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Curriculum setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Curriculum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public Curriculum setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Curriculum setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Curriculum setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Curriculum setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
        ", id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", orgId=" + orgId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", teacherId=" + teacherId +
        "}";
    }
}
