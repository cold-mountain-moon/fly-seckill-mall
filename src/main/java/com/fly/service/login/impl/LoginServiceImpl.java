package com.fly.service.login.impl;

import com.fly.constant.Constants;
import com.fly.domain.entity.user.Customer;
import com.fly.domain.vo.LoginVo;
import com.fly.exception.GlobalException;
import com.fly.mapper.CustomerMapper;
import com.fly.redis.RedisService;
import com.fly.redis.key.CustomerKey;
import com.fly.response.CodeMsg;
import com.fly.service.login.LoginService;
import com.fly.util.MD5Util;
import com.fly.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RedisService redisService;


    @Override
    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        String formPhone = loginVo.getPhone();
        String formPassword = loginVo.getPassword();

        Customer customer = customerMapper.getByPhone(formPhone);
        if(customer == null) {
            throw new GlobalException(CodeMsg.ERROR_LOGIN_NAME_OR_PASSWORD);
        }
        String salt = customer.getSalt();
        String passwordDb = customer.getPassword();
        String encryptedFormPassword = MD5Util.encryptFormInputToDB(formPassword, salt);
        if(!passwordDb.equals(encryptedFormPassword)) {
            throw new GlobalException(CodeMsg.ERROR_LOGIN_NAME_OR_PASSWORD);
        }
        // 生成token并缓存
        String token = UUIDUtil.UUID();
        redisService.setEx(CustomerKey.KEY_OF_TOKEN, token, customer, CustomerKey.KEY_OF_TOKEN.expireSeconds());

        // 将token设置在cookie中
        Cookie cookie = new Cookie(Constants.USER_TOKEN_NAME, token);
        cookie.setMaxAge(CustomerKey.KEY_OF_TOKEN.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }

}
