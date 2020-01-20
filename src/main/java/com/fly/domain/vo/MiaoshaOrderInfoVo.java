package com.fly.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/19 16:02
 */
@Data
@Accessors(chain = true)
public class MiaoshaOrderInfoVo {

    private Long orderId;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private BigDecimal goodsPrice;

    private BigDecimal orderAmount;

    private Integer goodsCount;

    private Integer orderStatus;

    private Date orderPayDate;

}
