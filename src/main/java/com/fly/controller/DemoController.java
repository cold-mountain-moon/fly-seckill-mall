package com.fly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping("/a")
    public String demo(Model model) {
        model.addAttribute("name", "fly");
        return "demo";
    }

}
