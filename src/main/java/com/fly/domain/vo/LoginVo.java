package com.fly.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description
 * @Compay 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/6 13:18
 **/
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class LoginVo {

    private String phone;

    private String password;

}
