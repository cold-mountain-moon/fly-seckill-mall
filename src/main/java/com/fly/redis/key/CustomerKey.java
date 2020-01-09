package com.fly.redis.key;

public class CustomerKey extends BasePrefix {

    private static final int TOKEN_EXPIRE_SECONDS = 2 * 24 * 60 * 60;

    private CustomerKey(String prefix) {
        super(prefix);
    }

    private CustomerKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }


    public static CustomerKey KEY_OF_ID = new CustomerKey("id");
    public static CustomerKey KEY_OF_NAME = new CustomerKey("name");
    public static CustomerKey KEY_OF_TOKEN = new CustomerKey(TOKEN_EXPIRE_SECONDS, "token");

}
