package com.ambow.service;

import java.util.List;

import com.ambow.entity.Curriculum;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程信息 服务类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
public interface CurriculumService extends IService<Curriculum> {

    public List<Curriculum> listByOrgId(String orgId);
}
