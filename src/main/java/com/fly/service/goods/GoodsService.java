package com.fly.service.goods;

import com.fly.domain.entity.goods.Goods;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/9 12:52
 */
public interface GoodsService {


    Goods get(Long id);

    List<Goods> list();

    Map<Long, Goods> getGoodsIdMap();


}
