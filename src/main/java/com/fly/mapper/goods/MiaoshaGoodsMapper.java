package com.fly.mapper.goods;

import com.fly.domain.entity.goods.MiaoshaGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MiaoshaGoodsMapper {

    @Select("select * from miaosha_goods")
    List<MiaoshaGoods> list();

}
