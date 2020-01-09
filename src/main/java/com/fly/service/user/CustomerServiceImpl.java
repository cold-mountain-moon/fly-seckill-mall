package com.fly.service.user;

import com.fly.domain.entity.user.Customer;
import com.fly.mapper.CustomerMapper;
import com.fly.redis.RedisService;
import com.fly.redis.key.CustomerKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Compay 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/4 20:32
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public Customer get(Long id) {
        return customerMapper.get(id);
    }

    @Override
    public Customer getByToken(@NonNull String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        return redisService.get(CustomerKey.KEY_OF_TOKEN, token, Customer.class);
    }
}
