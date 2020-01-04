package com.fly.service.impl;

import com.fly.entity.Customer;
import com.fly.mapper.CustomerMapper;
import com.fly.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Customer get(Long id) {
        return customerMapper.get(id);
    }
}
