package com.fly.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fly.redis.key.KeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.math.BigDecimal;

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 根据key获取单个值，并转换成对象对象
     * @param key
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> cls) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String redisStr = jedis.get(keyPrefix.getPrefix() + key);
            T t = stringToBean(redisStr, cls);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 设置key，永不过期
     * @param keyPrefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix keyPrefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if(str == null) {
                return false;
            }
            jedis.set(keyPrefix.getPrefix() + key, str);
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 设置key，并设置过期时间
     * @param keyPrefix
     * @param key
     * @param value
     * @param expire
     * @param <T>
     * @return
     */
    public <T> boolean setEx(KeyPrefix keyPrefix, String key, T value, int expire) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if(str == null) {
                return false;
            }
            jedis.setex(keyPrefix.getPrefix() + key, expire, str);
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 是否存在某个key
     * @param keyPrefix
     * @param key
     * @return
     */
    public boolean exists(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(keyPrefix.getPrefix() + key);
        } finally {
            returnToPool(jedis);
        }
    }


    private <T> T stringToBean(String redisStr, Class<T> cls) {
        if(redisStr == null || redisStr.length() == 0) {
            return null;
        }
        if(cls == String.class) {
            return (T)redisStr;
        }
        if(cls == int.class || cls == Integer.class) {
            return (T) Integer.valueOf(redisStr);
        }
        if(cls == long.class || cls == Long.class) {
            return (T) Long.valueOf(redisStr);
        }
        return JSONObject.parseObject(redisStr, cls);
    }



    private <T> String beanToString(T value) {
        if(value == null) {
            return null;
        }
        Class<?> aClass = value.getClass();
        if(aClass == String.class) {
            return (String) value;
        }
        if(aClass == int.class
                || aClass == Integer.class
                || aClass == Long.class
                || aClass == long.class
                || aClass == double.class
                || aClass == Double.class
                || aClass == float.class
                || aClass == Float.class
                || aClass == BigDecimal.class) {
            return String.valueOf(value);
        }
        return JSON.toJSONString(value);
    }



    private void returnToPool(Jedis jedis) {
        if(jedis != null) {
            jedis.close();
        }
    }


}
