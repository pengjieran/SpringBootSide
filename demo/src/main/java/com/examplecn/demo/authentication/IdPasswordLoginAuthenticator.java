/**
 * All rights Reserved, Designed By www.baiwang.com
 *
 * @author: 云平台技术部
 * @date: 2019/12/31 16:25
 * @version v2.0
 * @Copyright: 2019 www.baiwang.com Inc. All rights reserved. 注意：本内容仅限于百望股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.examplecn.demo.authentication;

import cn.hutool.crypto.SecureUtil;
import com.examplecn.demo.authentication.enumeration.IdType;
import com.examplecn.demo.authentication.enumeration.UserType;
import com.examplecn.demo.entity.Account;
import com.examplecn.demo.exception.AuthException;
import com.examplecn.demo.model.AuthModel;
import com.examplecn.demo.model.IdPasswordAuthModel;
import com.examplecn.demo.model.PropertyValueConstants;
import com.examplecn.demo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description:
 * @author: Aaron
 * @date: 2019/12/31 16:25
 */
@Component("idPasswordLoginAuthenticator")
public class IdPasswordLoginAuthenticator implements LoginAuthenticatorHandler {

    private static final Logger logger = LoggerFactory.getLogger(IdPasswordLoginAuthenticator.class);

    @Autowired
    private AccountService loginInfoService;

    public Account doAuthenticate(IdType idType, UserType userType, AuthModel authModel) throws Exception {

        IdPasswordAuthModel idPasswordAuthModel = (IdPasswordAuthModel) authModel;
        String loginId = idPasswordAuthModel.getLoginId();
        String password = idPasswordAuthModel.getPassword();

        if (Objects.isNull(idType)
                || Objects.isNull(userType)
                || Objects.isNull(loginId)
                || Objects.isNull(password)) {
            throw new AuthException("登录信息不能为空.");
        }

        Account loginInfoModel = this.loginInfoService.getByUsername(loginId);

        if (Objects.isNull(loginInfoModel))
            throw new AuthException("找不到用户信息.");

        if (PropertyValueConstants.LOCK_STATUS_LOCK.equals(loginInfoModel.getStatus())) {

            throw new AuthException("当前账号已经禁用,请联系管理员");
        } else if (Objects.isNull(loginInfoModel) || !loginInfoModel.getPassword().equals(SecureUtil.sha256(idPasswordAuthModel.getPassword()))) {

            throw new AuthException("用户名或密码有误");
        }
        return loginInfoModel;

    }
}
