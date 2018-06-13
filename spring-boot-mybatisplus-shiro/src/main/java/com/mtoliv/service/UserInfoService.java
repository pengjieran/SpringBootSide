package com.mtoliv.service;

import com.mtoliv.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Aaron
 * @since 2018-06-13
 */
public interface UserInfoService extends IService<UserInfo> {
	
	public UserInfo findByUsername(String username);

}