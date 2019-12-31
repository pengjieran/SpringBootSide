package com.examplecn.demo.authentication;

import cn.hutool.core.util.RandomUtil;
import com.examplecn.demo.authentication.enumeration.IdType;
import com.examplecn.demo.authentication.enumeration.ProvidedAuthType;
import com.examplecn.demo.authentication.enumeration.UserType;
import com.examplecn.demo.config.SpringContextHelper;
import com.examplecn.demo.entity.Account;
import com.examplecn.demo.exception.AuthException;
import com.examplecn.demo.exception.BaseException;
import com.examplecn.demo.model.AuthModel;
import com.examplecn.demo.model.PropertyValueConstants;
import com.examplecn.demo.model.RequestContext;
import com.examplecn.demo.model.SsoSessionsModel;
import com.examplecn.demo.service.SSOSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

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

    private static LoginAuthenticatorHandler getAuthenticator(ProvidedAuthType authType) throws Exception {
        return (LoginAuthenticatorHandler) SpringContextHelper.getBean(authType.getAuthenticator());
    }

    @Transactional(rollbackFor = {Exception.class, BaseException.class})
    public SsoSessionsModel createSession(IdType idType, ProvidedAuthType authType, UserType userType, AuthModel authModel) throws Exception {
        String product = RequestContext.getProduct();
        String requestIP = RequestContext.getRequestIP();
        String userAgent = RequestContext.getUserAgent();


        if (Objects.isNull(product)
                || Objects.isNull(requestIP)
                || Objects.isNull(userAgent)) {
            throw new AuthException("请求头信息不完整.");
        }

        SsoSessionsModel ssoSessionsModel = new SsoSessionsModel();
        ssoSessionsModel.setActionByAgent(userAgent);
        ssoSessionsModel.setActionByIp(requestIP);
        ssoSessionsModel.setActionByProduct(product);
        ssoSessionsModel.setSessionCreateTime(new Date());
        ssoSessionsModel.setSessionExpiration(SSOSessionService.DEFAULT_SESSION_EXPIRATION);
        ssoSessionsModel.setSessionStatus(PropertyValueConstants.SESSION_STATUS_ACTIVE);
        ssoSessionsModel.setUserType(userType.name());
        ssoSessionsModel.setToken(RandomUtil.randomString(25));
        if (UserType.ANONYMOUS.equals(userType)) {
            ssoSessionsModel.setAgencyCode(PropertyValueConstants.CODE_SUPER_ADMIN);
            ssoSessionsModel.setLoginId("admin");
            ssoSessionsModel.setUserId(ssoSessionsModel.getUserId());
            ssoSessionsModel.setUserName(userType.getLabel());
        } else {
            Account loginInfoModel = getAuthenticator(authType).doAuthenticate(idType, userType, authModel);
            //ssoSessionsModel.setAgencyCode(loginInfoModel.getAgencyCode());
            ssoSessionsModel.setLoginId(loginInfoModel.getUsername());
            ssoSessionsModel.setUserId(loginInfoModel.getUserId());
            ssoSessionsModel.setUserType(userType.name());

        }

        //保存session和登陆记录
        return createLoginHistory(ssoSessionsModel);
    }


    public HashMap<String, Object> authLogin(IdType idType, ProvidedAuthType authType, UserType userType, AuthModel authModel) throws Exception {
        SsoSessionsModel ssoSessionsModel = this.createSession(idType, authType, userType, authModel);
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put(PropertyValueConstants.TOKEN, ssoSessionsModel.getToken());
        result.put(PropertyValueConstants.EXPIRE, ssoSessionsModel.getSessionExpiration());
        result.put(PropertyValueConstants.USERID, ssoSessionsModel.getUserId());
        return result;
    }


    private SsoSessionsModel createLoginHistory(SsoSessionsModel ssoSessionsModel) throws Exception {

        RequestContext.setExeUserId(ssoSessionsModel.getUserId());
        RequestContext.setAgencyCode(ssoSessionsModel.getAgencyCode());
        RequestContext.setUserType(UserType.valueOf(ssoSessionsModel.getUserType()));

        //清理旧的session
        sessionService.removeSession(ssoSessionsModel.getActionByProduct(), ssoSessionsModel.getLoginId());

        return sessionService.createSession(ssoSessionsModel);
    }
}
