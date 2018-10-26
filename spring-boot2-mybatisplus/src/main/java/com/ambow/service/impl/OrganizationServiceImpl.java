package com.ambow.service.impl;

import com.ambow.entity.Organization;
import com.ambow.mapper.dao.OrganizationMapper;
import com.ambow.service.OrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-10-26
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;
    
    @Override
    public List<Organization> all() {
        
        return organizationMapper.selectList(null);
    }

}