package com.ambow.service.impl;

import com.ambow.entity.Student;
import com.ambow.mapper.dao.StudentMapper;
import com.ambow.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
