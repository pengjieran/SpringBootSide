package com.ambow.service.impl;

import com.ambow.entity.Curriculum;
import com.ambow.mapper.dao.CurriculumMapper;
import com.ambow.service.CurriculumService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程信息 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@Service
public class CurriculumServiceImpl extends ServiceImpl<CurriculumMapper, Curriculum> implements CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;
    
    @Override
    public List<Curriculum> listByOrgId(String orgId) {
        
        QueryWrapper<Curriculum> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("org_id", orgId);
        
        return curriculumMapper.selectList(queryWrapper);
    }

}
