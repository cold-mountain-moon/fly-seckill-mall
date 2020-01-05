package com.fly.redis.key;

public class CustomerKey extends BasePrefix {

    private CustomerKey(String prefix) {
        super(prefix);
    }

    public static CustomerKey KEY_OF_ID = new CustomerKey("id");
    public static CustomerKey KEY_OF_NAME = new CustomerKey("name");

}
