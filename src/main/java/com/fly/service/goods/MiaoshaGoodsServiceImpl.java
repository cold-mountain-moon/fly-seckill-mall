package com.fly.service.goods;

import com.fly.domain.entity.MiaoshaGoodsEntity;
import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.entity.order.OrderInfo;
import com.fly.domain.entity.order.OrderStatusEnum;
import com.fly.domain.entity.user.Customer;
import com.fly.domain.pojo.goods.Goods;
import com.fly.domain.pojo.order.MiaoshaOrder;
import com.fly.domain.vo.GoodsDetailVo;
import com.fly.domain.vo.MiaoshaGoodsVo;
import com.fly.domain.vo.MiaoshaOrderInfoVo;
import com.fly.exception.GlobalException;
import com.fly.mapper.goods.MiaoshaGoodsMapper;
import com.fly.redis.RedisService;
import com.fly.response.CodeMsg;
import com.fly.service.order.MiaoshaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MiaoshaGoodsServiceImpl implements MiaoshaGoodsService {

    @Autowired
    MiaoshaGoodsMapper miaoshaGoodsMapper;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private MiaoshaOrderService miaoshaOrderService;

    @Override
    public List<MiaoshaGoods> list() {
        List<MiaoshaGoods> list = miaoshaGoodsMapper.list();
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @Override
    public List<MiaoshaGoodsVo> listMiaoshaGoodsVo() {
        Map<Long, Goods> goodsIdMap = goodsService.getGoodsIdMap();
        List<MiaoshaGoods> list = list();
        final List<MiaoshaGoodsVo> vos = new ArrayList<>(list.size());
        list.stream().forEach(miaoshaGoods -> {
            Goods goods = goodsIdMap.get(miaoshaGoods.getGoodsId());
            MiaoshaGoodsVo vo = new MiaoshaGoodsVo(goods, miaoshaGoods);
            vos.add(vo);
        });
        return vos;
    }

    @Override
    public MiaoshaGoods getByGoodsId(Long goodsId) {
        MiaoshaGoods miaoshaGoods = miaoshaGoodsMapper.getByGoodsId(goodsId);
        return miaoshaGoods == null ? new MiaoshaGoods() : miaoshaGoods;
    }

    @Override
    public GoodsDetailVo miaoshaGoodsDetail(Long id) {
        Goods goods = goodsService.get(id);
        MiaoshaGoods miaoshaGoods = getByGoodsId(id);
        return MiaoshaGoodsEntity.toMiaoshaGoodsVo(goods, miaoshaGoods);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public MiaoshaOrderInfoVo doMiaosha(Customer customer, @NonNull Long goodsId) {
        // 检验商品是否存在
        MiaoshaGoods miaoshaGoods = getByGoodsId(goodsId);
        if(miaoshaGoods.getId() == null) {
            throw new GlobalException(CodeMsg.GOODS_NOT_FOUND);
        }
        Goods goods = goodsService.get(goodsId);
        if(goods == null) {
            throw new GlobalException(CodeMsg.GOODS_NOT_FOUND);
        }
        // 检查库存
        if(miaoshaGoods.getStockCount() <= 0) {
            throw new GlobalException(CodeMsg.STOCK_COUNT_NOT_ENOUGH);
        }
        String miaoshaRedisKey = customer + ":" + miaoshaGoods.getId();
        // 检查限购
//        Integer buyCount = redisService.get(MiaoshaKey.MIAOSHA_LIMIT, miaoshaRedisKey, Integer.class);
//        if(buyCount == 0 buyCount > 0) {
//
//        }
        MiaoshaOrder existedOrder = miaoshaOrderService.getByUserIdAndGoodsId(customer.getId(), goodsId);
        if(existedOrder != null) {
            throw new GlobalException(CodeMsg.NOT_ALLOWED_REPEAT_MIAOSHA);
        }

        // 生成订单
        OrderInfo orderInfo = miaoshaOrderService.createMiaoshaOrderInfo(goods, customer, miaoshaGoods);
        // 减去库存
        reduceStockCount(miaoshaGoods);
        MiaoshaOrderInfoVo result = new MiaoshaOrderInfoVo();
        result.setGoodsCount(orderInfo.getGoodsCount());
        result.setGoodsImg(goods.getGoodsImg());
        result.setGoodsName(orderInfo.getGoodsName());
        result.setGoodsPrice(orderInfo.getGoodsPrice());
        result.setGoodsTitle(goods.getGoodsTitle());
        result.setOrderAmount(orderInfo.getGoodsPrice());
        result.setOrderId(orderInfo.getId());
        result.setOrderStatus(orderInfo.getStatus());
        return result;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void reduceStockCount(MiaoshaGoods miaoshaGoods) {
        int reduceCount = miaoshaGoodsMapper.reduceStockCount(miaoshaGoods);
        if(reduceCount <= 0) {
            throw new GlobalException(CodeMsg.STOCK_COUNT_NOT_ENOUGH);
        }
    }
}
