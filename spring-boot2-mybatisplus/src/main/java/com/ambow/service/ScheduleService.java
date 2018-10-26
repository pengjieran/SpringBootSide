package com.ambow.service;

import java.util.List;

import com.ambow.entity.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程排期 服务类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
public interface ScheduleService extends IService<Schedule> {

    public List<Schedule> listByCurriculumId(String curriculumId);
}