package com.examplecn.demo.interceptor;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Sequence;
import com.examplecn.demo.authentication.enumeration.UserType;
import com.examplecn.demo.exception.AuthException;
import com.examplecn.demo.model.RequestContext;
import com.examplecn.demo.model.RestfulConstans;
import com.examplecn.demo.model.SsoSessionsModel;
import com.examplecn.demo.service.SSOSessionService;
import com.examplecn.demo.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Description:
 * @author: Aaron
 * @date: 2019/12/31 16:39
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    private static final Sequence sequence = new Sequence();

    @Autowired
    private SSOSessionService ssoSessionsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        RequestContext.clean();
        RequestContext.setRequestTimeMills(System.currentTimeMillis());

        String appkey       = request.getHeader(RestfulConstans.APPKEY);
        String token        = request.getHeader(RestfulConstans.TOKEN);
        String product      = request.getHeader(RestfulConstans.PRODUCT);
        String traceId      = request.getHeader(RestfulConstans.TRACEID);
        String deviceId     = request.getHeader(RestfulConstans.DEVICE_ID);
        String requestIp    = RequestUtil.getRemoteIp(request);
        String userAgent    = request.getHeader(RestfulConstans.USER_AGENT);

        //设置请求标识
        traceId = StrUtil.isBlank(traceId) ?String.valueOf(sequence.nextId()):traceId;

        RequestContext.setAppKey(appkey);
        RequestContext.setTraceId(traceId);
        RequestContext.setRequestIP(requestIp);
        RequestContext.setProduct(product);
        RequestContext.setUserAgent(userAgent);
        RequestContext.setToken(token);
        RequestContext.setDeviceId(deviceId);

        if(!(handler instanceof HandlerMethod)) //TODO 临时处理，再做打算
            return true;

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        StringBuilder logInfo = new StringBuilder();
        logInfo.append("\n**********************************************************");
        logInfo.append("\n* APP_KEY     :" + appkey);
        logInfo.append("\n* TOKEN       :" + token);
        logInfo.append("\n* PRODUCT     :" + product);
        logInfo.append("\n* REQUEST_IP  :" + requestIp);
        logInfo.append("\n* USER_AGENT  :" + userAgent);
        logInfo.append("\n* TRACE_ID    :" + traceId);
        logInfo.append("\n* HANDLER     :" + handlerMethod.getBean().getClass());
        logInfo.append("\n* METHOD      :" + handlerMethod.getMethod().getName());
        //logInfo.append("\n* ACCESS_TIME :" + DateUtil.getNow(DateUtil.Y_M_D_HMS));
        logger.info(logInfo.toString());

        return doAuth(handlerMethod,token,appkey,product);
    }

    private boolean doAuth(HandlerMethod handlerMethod, String token, String appKey, String product) throws Exception {

        //TycloudOperation tycloudOperation = handlerMethod.getMethodAnnotation(TycloudOperation.class);


        //在刷新session之前执行扩展规则验证
        //Boolean flag = ExtendAuthHandler.doAuth(handlerMethod,token,appKey,product);

        //跳过剩下所有校验.
        //if(flag)
        //    return true;


        //if(!tycloudOperation.needAuth())
        //    return true;

        if(StrUtil.isBlank(token))
            throw new AuthException("请求未包含认证信息.");

        SsoSessionsModel sessionsModel = null;
        if(!StrUtil.isBlank(token))
        {
            //刷新session：判断用户状态，登录信息状态，session是否过期,然后重置session过期时间并返回
            sessionsModel =  ssoSessionsService.refreshSession(token,product);
            if(Objects.isNull(sessionsModel))
                throw new AuthException("登录信息失效，请重新登录");

            //设置上下文信息
            RequestContext.setExeUserId(sessionsModel.getUserId());
            RequestContext.setAgencyCode(sessionsModel.getAgencyCode());
            RequestContext.setUserType(UserType.valueOf(sessionsModel.getUserType()));
            RequestContext.setLoginId(sessionsModel.getLoginId());

            //刷新session之后执行扩展规则验证
            //ExtendAuthHandler.doAuth(sessionsModel,handlerMethod,token,appKey,product);
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("\n* 请求耗时      :" + (System.currentTimeMillis()-RequestContext.getRequestTimeMills()) +"毫秒;  (TRACE_ID:"+RequestContext.getTraceId()+")");
        logInfo.append("\n**********************************************************");
        logger.info(logInfo.toString());
    }
}
