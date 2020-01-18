package com.fly.mapper.goods;

import com.fly.domain.pojo.goods.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/9 13:10
 */
@Mapper
public interface GoodsMapper {


    @Select("select * from goods where id = #{id}")
    Goods get(@Param("id") Long id);

    @Select("select * from goods")
    List<Goods> list();
}
