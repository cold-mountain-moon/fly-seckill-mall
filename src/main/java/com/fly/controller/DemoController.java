package com.fly.controller;

import com.fly.domain.entity.Customer;
import com.fly.redis.RedisService;
import com.fly.redis.key.CustomerKey;
import com.fly.response.CodeMsg;
import com.fly.response.Response;
import com.fly.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private RedisService redisServcie;

    @RequestMapping("/a")
    public String demo(Model model) {
        model.addAttribute("name", "fly");
        return "demo";
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Response<Customer> get(@PathVariable("id") Long id) {
        return Response.fail(CodeMsg.SERVER_ERROR);
//        return Response.success(customerService.get(id));
    }

    @GetMapping("/redis/test/set")
    @ResponseBody
    public String set() {
        boolean setResult = redisServcie.set(CustomerKey.KEY_OF_ID,"1", 1);
        if(setResult) {
            Integer integer = redisServcie.get(CustomerKey.KEY_OF_ID, "1", int.class);
            return String.valueOf(integer);
        }
        return null;
    }
}
