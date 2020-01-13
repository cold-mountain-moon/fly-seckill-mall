package com.fly.service.goods;

import com.fly.domain.entity.goods.Goods;
import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.vo.MiaoshaGoodsVo;
import com.fly.mapper.goods.MiaoshaGoodsMapper;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class MiaoshaGoodsServiceImpl implements MiaoshaGoodsService {

    @Autowired
    MiaoshaGoodsMapper miaoshaGoodsMapper;
    @Autowired
    private GoodsService goodsService;

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
}
