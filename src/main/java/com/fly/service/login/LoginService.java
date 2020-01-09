package com.fly.service.login;

import com.fly.domain.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

public interface LoginService {


    boolean login(HttpServletResponse response, LoginVo loginVo);
}
