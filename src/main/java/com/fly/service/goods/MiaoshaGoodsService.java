package com.fly.service.goods;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.entity.user.Customer;
import com.fly.domain.vo.GoodsDetailVo;
import com.fly.domain.vo.MiaoshaGoodsVo;
import com.fly.domain.vo.MiaoshaOrderInfoVo;

import java.util.List;

public interface MiaoshaGoodsService {

    List<MiaoshaGoods> list();

    List<MiaoshaGoodsVo> listMiaoshaGoodsVo();

    MiaoshaGoods getByGoodsId(Long goodsId);

    GoodsDetailVo miaoshaGoodsDetail(Long id);

    MiaoshaOrderInfoVo doMiaosha(Customer customer, Long goodsId);
}
