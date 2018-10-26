package com.ambow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学生与课程的关联
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@TableName("t_student_curriculum")
public class StudentCurriculum extends Model<StudentCurriculum> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String studentId;
    private String curriculumId;


    public String getId() {
        return id;
    }

    public StudentCurriculum setId(String id) {
        this.id = id;
        return this;
    }

    public String getStudentId() {
        return studentId;
    }

    public StudentCurriculum setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public StudentCurriculum setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudentCurriculum{" +
        ", id=" + id +
        ", studentId=" + studentId +
        ", curriculumId=" + curriculumId +
        "}";
    }
}
