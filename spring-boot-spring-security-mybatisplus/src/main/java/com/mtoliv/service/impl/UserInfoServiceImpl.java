package com.mtoliv.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
		
		EntityWrapper<UserInfo> userInfoWrapper = new EntityWrapper<UserInfo>();
		userInfoWrapper.addFilter("username={0}", username);
		
		return this.selectOne(userInfoWrapper);
	}

}
