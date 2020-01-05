package com.fly.redis.key;

public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();

}
