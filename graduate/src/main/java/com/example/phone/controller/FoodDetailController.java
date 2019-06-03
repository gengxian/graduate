package com.example.phone.controller;

import com.example.phone.Service.fooddetailService;
import com.example.phone.dao.fooddetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @param ligengxian 菜式详情页控制器
 */
@Controller
@RequestMapping(value = "/fooddetail", method = RequestMethod.POST)
public class FoodDetailController {
    @Autowired
    private fooddetailService FooddetailService;

    /**
     * @param ligengxian 通过菜式的名称找到菜式的详情页面
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public fooddetail finddetail(fooddetail Fooddetail) {
        return FooddetailService.finddetail(Fooddetail);
    }
}
