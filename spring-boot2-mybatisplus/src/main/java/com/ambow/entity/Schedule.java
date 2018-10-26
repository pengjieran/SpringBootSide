package com.ambow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 课程排期
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@TableName("t_schedule")
public class Schedule extends Model<Schedule> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String curriculumId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String teacherId;


    public String getId() {
        return id;
    }

    public Schedule setId(String id) {
        this.id = id;
        return this;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public Schedule setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Schedule setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Schedule setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Schedule setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Schedule{" +
        ", id=" + id +
        ", curriculumId=" + curriculumId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", teacherId=" + teacherId +
        "}";
    }
}
