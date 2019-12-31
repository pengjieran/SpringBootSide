/**
 * All rights Reserved, Designed By www.baiwang.com
 *
 * @author: 云平台技术部
 * @date: 2019/12/31 16:02
 * @version v2.0
 * @Copyright: 2019 www.baiwang.com Inc. All rights reserved. 注意：本内容仅限于百望股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.examplecn.demo.model;

import com.examplecn.demo.authentication.enumeration.UserType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/12/31 16:02
 */
public class RequestContextModel implements Serializable {

    private static final long serialVersionUID = -6237296664652045754L;

    private String agencyCode;

    private String traceId;

    private Long excutedUserId;

    private UserType userType;

    private String requestIP;

    private String userAgent;

    private String businessTransactionId;

    private String product;// 调用API的设备信息

    private String appVersion;

    private String token;

    private String loginId;

    private Long requestTimeMills;

    private String deviceId;

    private String  appKey;


    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getRequestTimeMills() {
        return requestTimeMills;
    }

    public void setRequestTimeMills(Long requestTimeMills) {
        this.requestTimeMills = requestTimeMills;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private Map<RequestContextEntityType, Object> extra;

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getRequestIP() {
        return requestIP;
    }

    public void setRequestIP(String requestIP) {
        this.requestIP = requestIP;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBusinessTransactionId() {
        return businessTransactionId;
    }

    public void setBusinessTransactionId(String businessTransactionId) {
        this.businessTransactionId = businessTransactionId;
    }

    public Long getExcutedUserId() {
        return excutedUserId;
    }

    public void setExcutedUserId(Long excutedUserId) {
        this.excutedUserId = excutedUserId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setAttribute(RequestContextEntityType key, Object value) {
        if (extra == null) {
            extra = new HashMap<RequestContextEntityType, Object>();
        }
        extra.put(key, value);
    }

    public Object getAttribute(RequestContextEntityType key) {
        if (extra == null) {
            return null;
        }
        return extra.get(key);
    }

    public void clean() {
        this.loginId = null;
        this.traceId = null;
        this.excutedUserId = null;
        this.agencyCode = null;
        this.userType = null;
        this.userAgent = null;
        this.businessTransactionId = null;
        this.product = null;
        this.appVersion = null;
        this.requestTimeMills = null;
        this.requestIP = null;
        this.token = null;
        if (this.extra != null) {
            this.extra = null;
        }
    }
}
