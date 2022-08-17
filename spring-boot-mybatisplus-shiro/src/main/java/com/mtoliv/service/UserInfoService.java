package com.mtoliv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mtoliv.entity.UserInfo;

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