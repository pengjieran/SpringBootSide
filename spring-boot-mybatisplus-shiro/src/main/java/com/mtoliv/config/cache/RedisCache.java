package com.mtoliv.config.cache;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisCache implements Cache {

	private final ReadWriteLock readWriteLock = new DummyReadWriteLock();

	private String id;

	@Autowired
	private static JedisPool pool;
	
	public RedisCache(final String id) {
		if (id == null) {
			
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;
	}

	private Object execute(RedisCallback callback) {
		
		Jedis jedis = pool.getResource();
		try {
			
			return callback.doWithRedis(jedis);
		} finally {
			
			jedis.close();
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public int getSize() {
		return (Integer) execute(new RedisCallback() {
			
			@Override
			public Object doWithRedis(Jedis jedis) {
				
				Map<byte[], byte[]> result = jedis.hgetAll(id.getBytes());
				return result.size();
			}
		});
	}

	@Override
	public void putObject(final Object key, final Object value) {
		execute(new RedisCallback() {
			
			@Override
			public Object doWithRedis(Jedis jedis) {
				
				jedis.hset(id.getBytes(), key.toString().getBytes(), SerializeUtil.serialize(value));
				return null;
			}
		});
	}

	@Override
	public Object getObject(final Object key) {
		return execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				
				return SerializeUtil.unserialize(jedis.hget(id.getBytes(), key.toString().getBytes()));
			}
		});
	}

	@Override
	public Object removeObject(final Object key) {
		
		return execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				
				return jedis.hdel(id, key.toString());
			}
		});
	}

	@Override
	public void clear() {
		execute(new RedisCallback() {
			@Override
			public Object doWithRedis(Jedis jedis) {
				jedis.del(id);
				return id;
			}
		});
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	@Override
	public String toString() {
		return "Redis {" + id + "}";
	}
}