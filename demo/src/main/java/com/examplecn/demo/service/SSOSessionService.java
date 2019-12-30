/**
 * All rights Reserved, Designed By www.baiwang.com
 *
 * @author: 云平台技术部
 * @date: 2019/12/30 19:25
 * @version v2.0
 * @Copyright: 2019 www.baiwang.com Inc. All rights reserved. 注意：本内容仅限于百望股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.examplecn.demo.service;

import com.examplecn.demo.entity.Account;
import com.examplecn.demo.exception.BaseException;
import com.examplecn.demo.model.SsoSessionsModel;
import com.examplecn.demo.utils.CacheType;
import com.examplecn.demo.utils.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/12/30 19:25
 */
@Component
public class SSOSessionService {

    public static final String SESSION = "SESSION";
    public static final String SESSION_TOKEN = "SESSION_TOKEN";

    public static Long DEFAULT_SESSION_EXPIRATION = 2592000L;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AccountService accountService;

    public static void setDefaultExpiration(Long expiration) {
        DEFAULT_SESSION_EXPIRATION = expiration;
    }

    public static String sessionCacheKeyWithToken(String token, String actionByProduct) {
        return Redis.genKey(CacheType.ERASABLE.name(), SESSION_TOKEN, actionByProduct, token);
    }

    public static String sessionCacheKeyWithLoginId(String loginId, String actionByProduct) {
        return Redis.genKey(CacheType.ERASABLE.name(), SESSION, actionByProduct, loginId);
    }

    /**
     * 刷新session
     *
     * @param token
     * @param actionByProduct
     * @return
     * @throws Exception
     */
    public SsoSessionsModel refreshSession(String token, String actionByProduct) throws Exception {

        SsoSessionsModel sessionsModel = (SsoSessionsModel) this.redisTemplate.opsForValue().get(sessionCacheKeyWithToken(token, actionByProduct));
        if (!Objects.isNull(sessionsModel)) {

            redisTemplate.expire(sessionCacheKeyWithToken(token, actionByProduct), DEFAULT_SESSION_EXPIRATION, TimeUnit.SECONDS);
            Account account = accountService.getByUsername(sessionsModel.getLoginId());
            if (Objects.isNull(account))
                throw new Exception("用户信息异常.");
            sessionsModel.setSessionExpiration(SSOSessionService.DEFAULT_SESSION_EXPIRATION);
        }
        return sessionsModel;
    }

    @Transactional(rollbackFor = {Exception.class, BaseException.class})
    public SsoSessionsModel createSession(SsoSessionsModel sessionsModel) throws Exception {
        this.removeSession(sessionsModel.getActionByProduct(), sessionsModel.getLoginId());
        this.redisTemplate.opsForValue().set(sessionCacheKeyWithToken(sessionsModel.getToken(), sessionsModel.getActionByProduct()), sessionsModel);
        this.redisTemplate.opsForValue().set(sessionCacheKeyWithLoginId(sessionsModel.getLoginId(), sessionsModel.getActionByProduct()), sessionsModel);

        redisTemplate.expire(sessionCacheKeyWithToken(sessionsModel.getToken(), sessionsModel.getActionByProduct()), DEFAULT_SESSION_EXPIRATION, TimeUnit.SECONDS);
        redisTemplate.expire(sessionCacheKeyWithLoginId(sessionsModel.getLoginId(), sessionsModel.getActionByProduct()), DEFAULT_SESSION_EXPIRATION, TimeUnit.SECONDS);


        return sessionsModel;
    }


    public void removeSession(String actionByProduct, String loginId) throws Exception {
        SsoSessionsModel sessionsModel = (SsoSessionsModel) this.redisTemplate.opsForValue().get(sessionCacheKeyWithLoginId(loginId, actionByProduct));
        if (!Objects.isNull(sessionsModel)) {
            this.redisTemplate.delete(sessionCacheKeyWithLoginId(loginId, actionByProduct));
            this.redisTemplate.delete(sessionCacheKeyWithToken(sessionsModel.getToken(), actionByProduct));
        }

    }

    public void removeAllSession(String[] products, String loginId) throws Exception {
        for (String product : products) {
            this.removeSession(product, loginId);
        }
    }

    public SsoSessionsModel queryByToken(String actionByProduct, String token) throws Exception {

        SsoSessionsModel sessionsModel = (SsoSessionsModel) this.redisTemplate.opsForValue().get(sessionCacheKeyWithToken(token, actionByProduct));
        return sessionsModel;
    }

    public SsoSessionsModel queryByLoginId(String actionByProduct, String loginId) throws Exception {

        SsoSessionsModel sessionsModel = (SsoSessionsModel) this.redisTemplate.opsForValue().get(sessionCacheKeyWithLoginId(loginId, actionByProduct));
        return sessionsModel;
    }
}
