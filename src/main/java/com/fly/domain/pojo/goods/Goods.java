package com.fly.domain.pojo.goods;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/18 21:54
 */
@Data
public class Goods {

    private Long id;

    private String goodsName;

    private String goodsImg;

    private String goodsTitle;

    private String goodsDetail;

    private BigDecimal goodsPrice;

    private BigDecimal goodsStock;

}
