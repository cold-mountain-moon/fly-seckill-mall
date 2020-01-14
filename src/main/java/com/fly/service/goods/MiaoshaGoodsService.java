package com.fly.service.goods;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.vo.GoodsDetailVo;
import com.fly.domain.vo.MiaoshaGoodsVo;

import java.util.List;

public interface MiaoshaGoodsService {

    List<MiaoshaGoods> list();

    List<MiaoshaGoodsVo> listMiaoshaGoodsVo();

    MiaoshaGoods getByGoodsId(Long goodsId);

    GoodsDetailVo miaoshaGoodsDetail(Long id);
}
