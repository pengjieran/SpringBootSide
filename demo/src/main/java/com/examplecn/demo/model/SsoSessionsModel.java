/**
 * All rights Reserved, Designed By www.baiwang.com
 *
 * @author: 云平台技术部
 * @date: 2019/12/30 19:22
 * @version v2.0
 * @Copyright: 2019 www.baiwang.com Inc. All rights reserved. 注意：本内容仅限于百望股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.examplecn.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/12/30 19:22
 */
@EqualsAndHashCode
@Data
public class SsoSessionsModel {

    private static final long serialVersionUID = 4645613132132132L;

    /**
     * 归属机构
     */
    private String agencyCode;
    /**
     * 登录账号
     */
    private String loginId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 来源产品
     */
    private String actionByProduct;
    /**
     * 来源IP
     */
    private String actionByIp;
    /**
     * 过期时限(秒）
     */
    private Long sessionExpiration;
    /**
     * session状态：激活，过期
     */
    private String sessionStatus;
    /**
     * 创建时间
     */
    private Date sessionCreateTime;


    private String actionByAgent;
    /**
     * 来源设备串码
     */
    private String sourceDeviceCode;
    /**
     * 来源平台
     */
    private String sourceOs;


    private String token;
}
