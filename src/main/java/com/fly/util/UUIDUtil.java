package com.fly.util;

import java.util.UUID;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/9 13:36
 */
public class UUIDUtil {

    private UUIDUtil() {
    }


    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
