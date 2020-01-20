package com.fly.domain.entity.order;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.entity.user.Customer;
import com.fly.domain.pojo.goods.Goods;
import com.fly.exception.GlobalException;
import com.fly.response.CodeMsg;
import org.springframework.lang.NonNull;

import java.util.Date;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/19 16:18
 */
public class OrderInfoFactory {

    private OrderInfoFactory() {}

    public static OrderInfo createMiaoshaOrder(@NonNull Goods goods, @NonNull MiaoshaGoods miaoshaGoods,
                                        @NonNull Customer customer) {
        if(goods == null || miaoshaGoods == null || miaoshaGoods.getId() == null) {
            throw new GlobalException(CodeMsg.GOODS_NOT_FOUND);
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(miaoshaGoods.getMiaoshaPrice());
        orderInfo.setCreateDate(new Date());
        orderInfo.setStatus(OrderStatusEnum.WAIT_PAY.getCode());
        orderInfo.setGoodsCount(1);

        return orderInfo;
    }

}
