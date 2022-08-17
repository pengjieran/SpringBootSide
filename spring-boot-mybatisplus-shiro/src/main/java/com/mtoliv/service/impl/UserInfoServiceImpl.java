package com.mtoliv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.mtoliv.entity.UserInfo;
import com.mtoliv.mapper.dao.UserInfoMapper;
import com.mtoliv.service.UserInfoService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2018-06-13
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

	@Override
	public UserInfo findByUsername(String username) {

		QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		
		return this.getOne(queryWrapper);
	}

}
