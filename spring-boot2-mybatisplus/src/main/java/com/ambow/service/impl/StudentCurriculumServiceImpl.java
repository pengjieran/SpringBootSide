package com.ambow.service.impl;

import com.ambow.entity.StudentCurriculum;
import com.ambow.mapper.dao.StudentCurriculumMapper;
import com.ambow.service.StudentCurriculumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生与课程的关联 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@Service
public class StudentCurriculumServiceImpl extends ServiceImpl<StudentCurriculumMapper, StudentCurriculum> implements StudentCurriculumService {

}
