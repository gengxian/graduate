package com.example.phone.controller;
import com.example.phone.Service.ClassificationService;
import com.example.phone.dao.fooddetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 调用各个板块的页面，并显示出来
 */
@Controller
@RequestMapping("/classification")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;
    /**
     * 调用家常菜页面
     */
    @ResponseBody
    @RequestMapping("/jia")
    public List<fooddetail> FoodAlljia(@RequestBody Map<String,Object> param){
        String foodtype= (String) param.get("foodtype");
        return  classificationService.SelectFoodjia(foodtype);
    }
    /**
     * 调用早餐
     */
    @ResponseBody
    @RequestMapping("/zao")
    public List<fooddetail> FoodAllzao(@RequestBody Map<String,Object> param){
        System.out.println(param);
        String foodtype= (String) param.get("foodtype");
        System.out.println(foodtype);
        System.out.println("我有进来早餐列表吗");
        List<fooddetail>list=  classificationService.SelectFoodzao(foodtype);
        return  list;
    }
    /**
     * 调用凉菜
     */
    @ResponseBody
    @RequestMapping("/liang")
    public List<fooddetail> FoodAllliang(@RequestBody Map<String,Object> param){
        String foodtype= (String) param.get("foodtype");
        return  classificationService.SelectFoodliang(foodtype);
    }
    /**
     * 调用家烘焙
     */
    @ResponseBody
    @RequestMapping("/hong")
    public List<fooddetail> FoodAllhong(@RequestBody Map<String,Object> param){
        String foodtype= (String) param.get("foodtype");
        return  classificationService.SelectFoodhong(foodtype);
    }
    /**
     * 调用家瘦身
     */
    @ResponseBody
    @RequestMapping("/shou")
    public List<fooddetail> FoodAllshou(@RequestBody Map<String,Object> param){
        String foodtype= (String) param.get("foodtype");
        return  classificationService.SelectFoodshou(foodtype);
    }
    /**
     * 调用家养生
     */
    @ResponseBody
    @RequestMapping("/yang")
    public List<fooddetail> FoodAllyang(@RequestBody Map<String,Object> param){
        String foodtype= (String) param.get("foodtype");
        return  classificationService.SelectFoodyang(foodtype);
    }
    /**
     * 调用家海鲜
     */
    @ResponseBody
    @RequestMapping("/hai")
    public List<fooddetail> FoodAllhai(@RequestBody Map<String,Object> param){
       System.out.println("我没有进来海鲜控制层吗");
        String foodtype= (String) param.get("foodtype");
        System.out.println(foodtype);
        return  classificationService.SelectFoodhai(foodtype);
    }
    /**
     * 调用家靓汤
     */
    @ResponseBody
    @RequestMapping("/tang")
    public List<fooddetail> FoodAlltang(@RequestBody Map<String,Object> param){
        String foodtype= (String) param.get("foodtype");
        return  classificationService.SelectFoodtang(foodtype);
    }


}
