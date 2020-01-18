package com.fly.domain.vo;

import com.fly.domain.pojo.goods.Goods;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsDetailVo extends Goods {


    private Date startDate;
    private Date endDate;
    private BigDecimal miaoshaPrice;
    private Integer stockCount;

    /**
     * 秒杀状态：1.未开始 2.进行中 3.已结束
     */
    private Integer miaoshaStatus;

    /**
     * 秒杀倒计时：秒杀状态为1时有值，单位s
     */
    private Long remainSeconds;

    public Long getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(Long remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public Integer getMiaoshaStatus() {
        return miaoshaStatus;
    }

    public void setMiaoshaStatus(Integer miaoshaStatus) {
        this.miaoshaStatus = miaoshaStatus;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public BigDecimal getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public void setMiaoshaPrice(BigDecimal miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
