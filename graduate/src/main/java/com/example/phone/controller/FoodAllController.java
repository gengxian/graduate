package com.example.phone.controller;

import com.example.phone.Service.foodAllService;
import com.example.phone.Service.matchService;
import com.example.phone.dao.fooddetail;
import com.example.phone.dao.matchh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @param ligengxian 显示所有的
 */
@Controller
@RequestMapping(value = "/food")
public class FoodAllController {
    @Autowired
    private matchService ms;
    @Autowired
    private foodAllService foodallService;
    /**
     * @param ligengxian
     * 当前位置城市找到当前位置的菜式
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/all")
  public List<fooddetail> FoodAll(@RequestBody Map<String,Object>param){
        System.out.println("wo you jinlai a ");
          String belong= (String) param.get("city");
     List<fooddetail>list= foodallService.SelectFood(belong);
     System.out.println(list);
     return list;

  }
    /**
     * 显示前评分最高的十条数据
     */
    @ResponseBody
    @RequestMapping("/top")
    public List<fooddetail>FoodAlltop10(){
        List<fooddetail>list=foodallService.SelectFoodtop10();
        return list;
    }
    /**
     * 显示浏览记录的信息
     */
    @ResponseBody
    @RequestMapping("liulan")
    public Map<String, Object> foodliulan(@RequestBody Map<String,Object>map){
        System.out.println(map);
        String openid=(String)map.get("openid");
        /**
         * 通过openid获取数据
         */

        List<matchh>list=  ms.select2(openid);
        Map<String,Object>map1=new HashMap<>();

        /**
         * 判断是否是为空
         */
        if (list.isEmpty())
        {
            map1.put("data",0);
            return map1  ;
        }
        map1.put("data",list);
        return map1;

    }

}
