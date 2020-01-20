package com.fly.mapper.order;

import com.fly.domain.pojo.order.MiaoshaOrder;
import org.apache.ibatis.annotations.*;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/19 17:43
 */
@Mapper
public interface MiaoshaOrderMapper {

    @Select("select * from miaosha_order where user_id = #{userId} and goods_id = #{goodsId} limit 1")
    MiaoshaOrder getByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    @Insert("insert into miaosha_order(user_id, goods_id, order_id) " +
            "values(#{userId}, #{goodsId}, #{orderId})")
    void insert(MiaoshaOrder miaoshaOrder);
}
