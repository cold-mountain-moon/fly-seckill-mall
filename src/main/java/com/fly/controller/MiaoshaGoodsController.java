package com.fly.controller;

import com.fly.domain.entity.user.Customer;
import com.fly.domain.vo.MiaoshaGoodsVo;
import com.fly.domain.vo.MiaoshaOrderInfoVo;
import com.fly.service.goods.MiaoshaGoodsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaGoodsController {

    @Autowired
    private MiaoshaGoodsService miaoshaGoodsService;

    @RequestMapping("/goods_list")
    public String list(Model model, Customer customer) {
        model.addAttribute("user", customer);
        List<MiaoshaGoodsVo> goodsList = miaoshaGoodsService.listMiaoshaGoodsVo();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    @RequestMapping("/do_miaosha")
    public String doMiaosha(Model model, Customer customer, Long goodsId) {
        model.addAttribute("user", customer);
        MiaoshaOrderInfoVo miaoshaOrderInfoVo = miaoshaGoodsService.doMiaosha(customer, goodsId);
        model.addAttribute("orderInfo", miaoshaOrderInfoVo);
        return "order_detail";
    }


}
