package com.example.phone.controller;

import com.example.phone.Service.ClassificationService;
import com.example.phone.Service.matchService;
import com.example.phone.dao.fooddetail;
import com.example.phone.dao.matchh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 样式的详情的信息。
 * 通过详情信息说明该用户浏览过该页面，记录该浏览记录
 */
@Controller
@RequestMapping("/detail")
public class PageDetailController {
    @Autowired
    private matchService matchservice;
    @Autowired
    private ClassificationService classificationService;
    @ResponseBody
    @RequestMapping("/de")
    public fooddetail Selectdetail(@RequestBody Map<String,Object> param){

        System.out.println(param);
        //拿到openid存放进数据源库中
        String openid=(String)param.get("openid");

        String food= (String) param.get("food");
        matchh Match=new matchh();
        Match.setOpenid(openid);
        Match.setFood(food);
        /**
         * 先判断是否是存在数据库中，如果存在的话，就就不进行数据的插入
         */
        List<matchh>list=matchservice.selectfood(Match);
        if (list.isEmpty())
        {
            //说明数据库中没有数据，直接插进数据
            matchservice.addfoodopenid(Match);
        }
        System.out.println(food);
        /**
         * 拿到值之后从数据库中找出该详情信息
         */

        return  classificationService.SelectFoodDetail0(food);
    }
}
