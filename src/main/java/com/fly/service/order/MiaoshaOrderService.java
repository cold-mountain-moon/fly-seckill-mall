package com.fly.service.order;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.entity.order.OrderInfo;
import com.fly.domain.entity.user.Customer;
import com.fly.domain.pojo.goods.Goods;
import com.fly.domain.pojo.order.MiaoshaOrder;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/19 17:39
 */
public interface MiaoshaOrderService {

    MiaoshaOrder getByUserIdAndGoodsId(Long userId, Long goodsId);

    OrderInfo createMiaoshaOrderInfo(@NonNull Goods goods, @NonNull Customer customer, @NonNull MiaoshaGoods miaoshaGoods);
}
