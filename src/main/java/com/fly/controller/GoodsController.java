package com.fly.controller;

import com.fly.domain.entity.goods.Goods;
import com.fly.domain.entity.goods.MiaoshaGoods;
import com.fly.domain.entity.user.Customer;
import com.fly.domain.vo.GoodsDetailVo;
import com.fly.service.goods.GoodsService;
import com.fly.service.goods.MiaoshaGoodsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

/**
 * @Description TODO
 * @Company 北京岚时科技
 * @Version v1.0
 * @Author liheng
 * @Date 2020/1/9 12:51
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private MiaoshaGoodsService miaoshaGoodsService;

    @GetMapping("/goods_list")
    public String toGoodsList(Model model, Customer customer) {
        List<Goods> list = goodsService.list();
        model.addAttribute("user", customer);
        model.addAttribute("goodsList", list);
        return "goods_list";
    }

    @GetMapping("/detail/{id}")
    public String goodsDetial(@PathVariable("id") Long id, Model model, Customer customer) {
        GoodsDetailVo goods = miaoshaGoodsService.miaoshaGoodsDetail(id);
        model.addAttribute("user", customer);
        model.addAttribute("goods", goods);
        return "goods_detail";
    }





}
