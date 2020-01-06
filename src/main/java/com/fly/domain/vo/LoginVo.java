package com.fly.domain.vo;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Compay 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/6 13:18
 **/
//@Data
//@NoArgsConstructor
//@ToString
//@AllArgsConstructor
public class LoginVo {

    @NotEmpty(message = "手机号不能为空")
    private String phone;

    @NotEmpty(message = "密码不能为空")
    private String password;

    public LoginVo() {
    }

    public LoginVo(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
