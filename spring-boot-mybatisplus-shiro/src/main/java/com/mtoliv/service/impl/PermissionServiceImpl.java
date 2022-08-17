package com.mtoliv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mtoliv.entity.Permission;
import com.mtoliv.mapper.dao.PermissionMapper;
import com.mtoliv.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-06-13
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
