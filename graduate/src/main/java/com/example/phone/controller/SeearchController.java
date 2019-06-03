package com.example.phone.controller;

import com.example.phone.Service.ClassificationService;
import com.example.phone.Service.foodAllService;
import com.example.phone.Service.fooddetailService;
import com.example.phone.dao.fooddetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 搜索框输入的内容进行搜索结果
 */
@Controller
@RequestMapping("/search")
public class SeearchController {
    @Autowired
    private fooddetailService fds;
    @Autowired
    private ClassificationService classificationService;
    @Autowired
    private foodAllService  foodall;
    public  int count=0;
    /**
     * 输入的内容是菜名
     * @param ligengxian
     */
    @ResponseBody
    @RequestMapping("/result")
    public fooddetail SearchResult(@RequestBody Map<String,Object>map){
        System.out.println(map);
        String food= (String) map.get("food");
        /**
         * 该菜名的点击量加一,
         *
         */
           boolean fa= fds.selet(food);
           System.out.println("数量加1了吗"+fa);
       fooddetail FD= classificationService.SelectFoodDetail0(food);
        return FD;
    }
    /**
     * 选择的是地区，将展示该地区的菜式
     */
    @ResponseBody
    @RequestMapping("/result1")
    public List<fooddetail> SearchResult1(@RequestBody Map<String,Object>param){
        System.out.println("wo you jinlai a ");
        String belong= (String) param.get("city");
        List<fooddetail>list= foodall.SelectFood(belong);
        System.out.println(list);
        return list;

//        return "jjjjjj";
    }
    @ResponseBody
    @RequestMapping("fore")
    public List<fooddetail> se(){

        return fds.sel();
    }
}
