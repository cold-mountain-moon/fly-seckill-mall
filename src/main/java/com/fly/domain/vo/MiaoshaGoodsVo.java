package com.fly.domain.vo;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.pojo.goods.Goods;

import java.math.BigDecimal;

public class MiaoshaGoodsVo extends Goods {

    private BigDecimal miaoshaPrice;

    private int stockCount;

    public MiaoshaGoodsVo() {
    }

    public MiaoshaGoodsVo(Goods goods, MiaoshaGoods miaoshaGoods) {
        this.setId(miaoshaGoods.getId());
        this.setGoodsDetail(goods.getGoodsDetail());
        this.setGoodsImg(goods.getGoodsImg());
        this.setGoodsName(goods.getGoodsName());
        this.setGoodsPrice(goods.getGoodsPrice());
        this.setGoodsStock(goods.getGoodsStock());
        this.setGoodsTitle(goods.getGoodsTitle());
        this.setStockCount(miaoshaGoods.getStockCount());
        this.setMiaoshaPrice(miaoshaGoods.getMiaoshaPrice());
    }

    public BigDecimal getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public void setMiaoshaPrice(BigDecimal miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
