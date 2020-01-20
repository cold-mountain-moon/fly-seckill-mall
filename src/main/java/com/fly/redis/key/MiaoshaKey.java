package com.fly.redis.key;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/19 17:25
 */
public class MiaoshaKey extends BaseKeyPrefix{


    public MiaoshaKey(String prefix) {
        super(prefix);
    }

    public MiaoshaKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public final static MiaoshaKey MIAOSHA_LIMIT = new MiaoshaKey("miaosha:limit");
}
