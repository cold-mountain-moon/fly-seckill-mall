package com.fly.config;

import com.fly.constant.Constants;
import com.fly.domain.entity.user.Customer;
import com.fly.service.user.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/9 13:24
 */
@Configuration
public class UserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private CustomerService customerService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> parameterType = methodParameter.getParameterType();
        return parameterType == Customer.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeRequest(HttpServletResponse.class);

        String cookieToken = getCookieValue(request, Constants.USER_TOKEN_NAME);
        if(StringUtils.isEmpty(cookieToken)) {
            return null;
        }
        return customerService.getByToken(cookieToken);
    }

    /**
     * 获取cookie
     * @param request
     * @param cookieName
     * @return
     */
    private String getCookieValue(HttpServletRequest request, String cookieName) {
        if(StringUtils.isEmpty(cookieName)) {
            return null;
        }
        Cookie[] cookies = request.getCookies();
        if(cookies == null || cookies.length == 0) {
            return null;
        }
        for(Cookie cookie : cookies) {
            String name = cookie.getName();
            if(cookieName.equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
