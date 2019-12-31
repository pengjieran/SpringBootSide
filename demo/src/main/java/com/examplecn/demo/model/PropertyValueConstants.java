package com.examplecn.demo.model;

/**
 * @Description:
 * @author: Aaron
 * @date: 2019/12/31 16:10
 */
public class PropertyValueConstants {

    //数据有效性--有效
    public static final String DATD_STATUS_ACTIVE = "ACTIVE";
    //数据有效性--失效
    public static final String DATD_STATUS_INACTIVE = "INACTIVE";


    //锁定状态--锁定
    public static final String LOCK_STATUS_LOCK = "LOCK";
    //锁定状态--解锁
    public static final String LOCK_STATUS_UNLOCK = "UNLOCK";

    //会话状态--活动的
    public static final String SESSION_STATUS_ACTIVE = "ACTIVE";
    //会话状态--过期
    public static final String SESSION_STATUS_EXPIRED = "EXPIRED";

    public static final String EXPIRE = "expire";

    public static final String USERID = "userId";

    public static final String TOKEN = "token";

    public static final String CODE_SUPER_ADMIN  = "SUPER_ADMIN";

    public static final int PASSWORD_SALT_LENGTH = 10;

    public static final String  DEFAULT_PASSWORD = "a123456";


    public static final String ENVIRONMENT_DEV  = "dev";
    public static final String ENVIRONMENT_QA  = "qa";
    public static final String ENVIRONMENT_PT  = "pt";
}
