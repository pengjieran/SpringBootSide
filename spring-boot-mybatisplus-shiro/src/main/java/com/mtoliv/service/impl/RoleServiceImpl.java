package com.mtoliv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mtoliv.entity.Role;
import com.mtoliv.mapper.dao.RoleMapper;
import com.mtoliv.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
