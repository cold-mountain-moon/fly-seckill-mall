package com.fly.controller;

import com.fly.entity.Customer;
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

    @RequestMapping("/a")
    public String demo(Model model) {
        model.addAttribute("name", "fly");
        return "demo";
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer get(@PathVariable("id") Long id) {
        return customerService.get(id);
    }

}
