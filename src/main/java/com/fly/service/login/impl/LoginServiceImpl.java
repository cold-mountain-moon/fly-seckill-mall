package com.fly.service.login.impl;

import com.fly.domain.entity.Customer;
import com.fly.domain.vo.LoginVo;
import com.fly.exception.GlobalException;
import com.fly.mapper.CustomerMapper;
import com.fly.response.CodeMsg;
import com.fly.service.login.LoginService;
import com.fly.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public boolean login(LoginVo loginVo) {
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
        return true;
    }

}
