package com.fly.domain.entity.order;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/19 16:22
 */
public enum OrderStatusEnum {

    WAIT_PAY(1, "待支付"),
    WAIT_SEND_GOODS(2, "待发货"),
    HAS_SEND_GOODS(3, "已发货"),
    HAS_RECEIVE_GOODS(4, "已收货"),
    HAS_REFUND(5, "已退款"),
    FINISHED(6, "已完成")
    ;

    private Integer code;

    private String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }
}
