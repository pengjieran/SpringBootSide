package com.ambow.service.impl;

import com.ambow.entity.Schedule;
import com.ambow.mapper.dao.ScheduleMapper;
import com.ambow.service.ScheduleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程排期 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    
    @Override
    public List<Schedule> listByCurriculumId(String curriculumId) {
        
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("curriculum_id", curriculumId);
        
        return scheduleMapper.selectList(queryWrapper);
    }

}
