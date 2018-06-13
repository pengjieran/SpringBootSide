package com.mtoliv.config.cache;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.mtoliv.entity.UserInfo;
import com.mtoliv.service.UserInfoService;

public class MyShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		
		System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		
	    //获取用户的输入的账号.
	    String username = usernamePasswordToken.getUsername();
	    String credentials = new String(usernamePasswordToken.getPassword());
	    System.out.println(credentials);
	    //通过username从数据库中查找 User对象，如果找到，没找到.
	    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
	    UserInfo userInfo = userInfoService.findByUsername(username);
	    System.out.println("----->>userInfo="+userInfo);
	    if(userInfo == null) {
	    	
	        return null;
	    }
	    
	    return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), getName());
	}

}