package com.fly.domain.entity;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.pojo.goods.Goods;
import com.fly.domain.vo.GoodsDetailVo;
import com.fly.exception.GlobalException;
import com.fly.response.CodeMsg;

import java.util.Date;

public class MiaoshaGoodsEntity {

    private MiaoshaGoodsEntity() {

    }

    public static GoodsDetailVo toMiaoshaGoodsVo(Goods goods, MiaoshaGoods miaoshaGoods) {
        if(goods == null || miaoshaGoods == null) {
            throw new GlobalException(CodeMsg.GOODS_NOT_FOUND);
        }
        GoodsDetailVo vo = new GoodsDetailVo();
        vo.setId(miaoshaGoods.getId());
        Date startDate = miaoshaGoods.getStartDate();
        vo.setStartDate(startDate);
        Date endDate = miaoshaGoods.getEndDate();
        vo.setEndDate(endDate);
        vo.setGoodsTitle(goods.getGoodsTitle());
        vo.setGoodsStock(goods.getGoodsStock());
        vo.setGoodsPrice(goods.getGoodsPrice());
        vo.setGoodsName(goods.getGoodsName());
        vo.setGoodsImg(goods.getGoodsImg());
        vo.setGoodsDetail(goods.getGoodsDetail());
        vo.setStockCount(miaoshaGoods.getStockCount());
        vo.setMiaoshaPrice(miaoshaGoods.getMiaoshaPrice());
        long now = System.currentTimeMillis();
        if(startDate.getTime() > now) {
            vo.setMiaoshaStatus(1);
            vo.setRemainSeconds((now - startDate.getTime()) / 1000);
        } else if(endDate.getTime() < now) {
            vo.setMiaoshaStatus(3);
        } else {
            vo.setMiaoshaStatus(2);
        }
        return vo;
    }

}
