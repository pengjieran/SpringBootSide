package com.examplecn.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/12/30 19:27
 */
public class Redis {

    public static String VAR_SPLITOR = ":";

    public  static RedisTemplate redisTemplate;

    public static RedisTemplate getRedisTemplate()
    {
        return redisTemplate;
    }

    public static String genKey(String... keyMembers) {
        return StringUtils.join(keyMembers, VAR_SPLITOR).toUpperCase();
    }
}
