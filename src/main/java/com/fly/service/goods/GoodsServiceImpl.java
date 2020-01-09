package com.fly.service.goods;

import com.fly.domain.entity.goods.Goods;
import com.fly.mapper.goods.GoodsMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/9 12:53
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods get(Long id) {
        Goods goods = goodsMapper.get(id);
        return goods;
    }

    @Override
    public List<Goods> list() {
        List<Goods> list = goodsMapper.list();
        return CollectionUtils.isEmpty(list) ? Collections.EMPTY_LIST : list;
    }
}
