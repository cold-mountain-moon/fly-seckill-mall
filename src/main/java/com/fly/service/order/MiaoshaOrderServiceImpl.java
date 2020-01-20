package com.fly.service.order;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.entity.order.OrderInfo;
import com.fly.domain.entity.order.OrderStatusEnum;
import com.fly.domain.entity.user.Customer;
import com.fly.domain.pojo.goods.Goods;
import com.fly.domain.pojo.order.MiaoshaOrder;
import com.fly.mapper.order.MiaoshaOrderMapper;
import com.fly.mapper.order.OrderInfoMapper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/19 17:42
 */
@Service
@Slf4j
public class MiaoshaOrderServiceImpl implements MiaoshaOrderService {

    @Autowired
    private MiaoshaOrderMapper miaoshaOrderMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public MiaoshaOrder getByUserIdAndGoodsId(@NonNull Long userId, @NonNull Long goodsId) {
        return miaoshaOrderMapper.getByUserIdAndGoodsId(userId, goodsId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public OrderInfo createMiaoshaOrderInfo(@NonNull Goods goods, @NonNull Customer customer, @NonNull MiaoshaGoods miaoshaGoods) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsCount(1);
        orderInfo.setStatus(OrderStatusEnum.WAIT_PAY.getCode());
        orderInfo.setCreateDate(new Date());
        orderInfo.setGoodsPrice(miaoshaGoods.getMiaoshaPrice());
        orderInfo.setUserId(customer.getId());
        orderInfo.setDeliveryAddrId(2L);
        orderInfo.setOrderChannel(1);
        orderInfoMapper.insert(orderInfo);

        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setGoodsId(goods.getId());
        miaoshaOrder.setOrderId(orderInfo.getId());
        miaoshaOrder.setUserId(customer.getId());
        miaoshaOrderMapper.insert(miaoshaOrder);
        return orderInfo;
    }
}
