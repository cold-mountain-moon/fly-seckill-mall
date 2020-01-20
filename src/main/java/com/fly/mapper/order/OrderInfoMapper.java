package com.fly.mapper.order;

import com.fly.domain.entity.order.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/9 13:11
 */
@Mapper
public interface OrderInfoMapper {

    @Insert(value = "insert into order_info(id, user_id, goods_id, goods_name, " +
            "goods_count, goods_price, status, create_date, delivery_addr_id, order_channel) " +
            "values(#{id}, #{userId}, #{goodsId}, #{goodsName}," +
            "#{goodsCount}, #{goodsPrice}, #{status}, #{createDate}, #{deliveryAddrId}, #{orderChannel})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Long.class,
            statement = "select last_insert_id()", before = false)
    void insert(OrderInfo orderInfo);
}
