package com.fly.mapper.goods;

import com.fly.domain.entity.goods.MiaoshaGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MiaoshaGoodsMapper {

    @Select("select * from miaosha_goods")
    List<MiaoshaGoods> list();

    @Select("select * from miaosha_goods where goods_id = #{goodsId}")
    MiaoshaGoods getByGoodsId(@Param("goodsId") Long goodsId);
}
