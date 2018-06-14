package com.mtoliv.config.cache;

import redis.clients.jedis.Jedis;

public interface RedisCallback {

	Object doWithRedis(Jedis jedis);
}