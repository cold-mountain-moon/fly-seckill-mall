package com.fly.controller;

import com.fly.domain.vo.LoginVo;
import com.fly.response.Response;
import com.fly.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description
 * @Compay 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/6 13:14
 **/
@Controller
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Response<Boolean> login(@RequestBody @Valid LoginVo loginVo) {
        return Response.success(loginService.login(loginVo));
    }


}
