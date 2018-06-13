package com.mtoliv.config.cache.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

public class JedisCache<K, V> implements Cache<K, V>, Serializable {

	private static final long serialVersionUID = 2740859074030770628L;

	private static final String REDIS_SHIRO_CACHE = "shiro-cache:";
	
    private String cacheKey;
    
    private RedisTemplate<K, V> redisTemplate;
    
    private long globExpire = 30;

    @SuppressWarnings("unchecked")
	public JedisCache(String name, RedisTemplate redisTemplate) {
    	
        this.cacheKey = REDIS_SHIRO_CACHE + name + ":";
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) {
    	
        redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public V put(K key, V value) {
        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }

    @Override
    public V remove(K key) {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    private K getCacheKey(Object k) {
    	
        return (K) (this.cacheKey + k);
    }
}
