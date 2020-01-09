package com.fly.service.user;

import com.fly.domain.entity.user.Customer;
import org.springframework.lang.NonNull;

/**
 * @Description
 * @Compay 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/4 20:32
 **/
public interface CustomerService {

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    Customer get(Long id);

    /**
     * 根据token获取用户
     * @param token
     * @return
     */
    Customer getByToken(@NonNull String token);
}
