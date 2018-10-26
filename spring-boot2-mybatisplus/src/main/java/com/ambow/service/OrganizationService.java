package com.ambow.service;

import java.util.List;

import com.ambow.entity.Organization;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
public interface OrganizationService extends IService<Organization> {

    public List<Organization> all();
}