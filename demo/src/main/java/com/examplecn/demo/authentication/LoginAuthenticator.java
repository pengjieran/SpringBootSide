package com.examplecn.demo.authentication;

import com.examplecn.demo.authentication.enumeration.ProvidedAuthType;
import com.examplecn.demo.config.SpringContextHelper;
import com.examplecn.demo.service.SSOSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 登录授权
 * @author: Aaron
 * @date: 2019/12/30 19:08
 */
@Component
public class LoginAuthenticator {

    @Autowired
    private SSOSessionService sessionService;

    private static final Logger logger = LoggerFactory.getLogger(LoginAuthenticator.class);

    private   static LoginAuthenticatorHandler getAuthenticator(ProvidedAuthType authType) throws Exception {
        return (LoginAuthenticatorHandler) SpringContextHelper.getBean(authType.getAuthenticator());
    }
}
