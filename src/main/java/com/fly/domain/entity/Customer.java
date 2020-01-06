package com.fly.domain.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Compay 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/4 20:28
 **/
//@Data
//@ToString
public class Customer {

    private Long id;

    private String phone;

    private String name;

    private String password;

    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
