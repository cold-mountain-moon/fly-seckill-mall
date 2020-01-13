package com.fly.service.goods;

import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.vo.MiaoshaGoodsVo;

import java.util.List;

public interface MiaoshaGoodsService {

    List<MiaoshaGoods> list();

    List<MiaoshaGoodsVo> listMiaoshaGoodsVo();
}
