package com.fly.mapper;

import com.fly.domain.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Compay 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/4 20:33
 **/
@Mapper
public interface CustomerMapper {


    @Select("select id, name from customer where id = #{id}")
    Customer get(@Param("id") Long id);
}
