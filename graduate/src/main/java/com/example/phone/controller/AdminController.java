package com.example.phone.controller;

import com.example.phone.Service.ApplicationService;
import com.example.phone.Service.fooddetailService;
import com.example.phone.dao.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private fooddetailService fss;
    @Autowired
    private ApplicationService aps;
    @ResponseBody
    @RequestMapping("/adminlogin")
  public String adminlogin(@RequestBody Map<String,Object>map){
      System.out.println(map);
      String username= (String) map.get("username");
      String  password= (String) map.get("password");
      if(username.equals("1223519259")&&password.equals("ac2535172"))
      {
          return "200";
      }
     return "400";
  }
    @ResponseBody
    @RequestMapping("/admincheck")
    public String admincheck(@RequestBody Map<String,Object>map){
        System.out.println(map);
        String food= (String) map.get("food");
        String foodtype= (String) map.get("foodtype");
        String description= (String) map.get("description");
        String opcreate= (String) map.get("opcreate");
        String urlpath=(String)map.get("urlpath");
        String belong= (String) map.get("belong");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String createtime = dateFormat.format(new Date());
        System.out.println(createtime);
//food,foodtype,createtime,opcreate,urlpath,opcreate,belong
        aps.insertapplication(food,foodtype,createtime,description,opcreate,urlpath,belong);
        return "200";
    }
    @ResponseBody
    @RequestMapping("/chakan")
    public List<application> chakan(){
       List<application>li= aps.chakan();
        return li;
    }
    @ResponseBody
    @RequestMapping("/detail")
    public Map<String, Object> detaillist(@RequestBody Map<String,Object>map){
        System.out.println(map);
        String food=(String) map.get("food");
        application ap= aps.seleceonly(food);
        Map<String,Object>map1=new HashMap<>();
        map1.put("application",ap);
        System.out.println(map1);
        return map1;
    }
    @ResponseBody
    @RequestMapping("/pass")
    public String pass(@RequestBody  Map<String,Object>map){
       String food= (String) map.get("food");
       System.out.println(map);
        /**
         * 将该申请表的数据拿出来插进食物表中，然后把申请表中的数据删除
         */
       application apss= aps.seleceonlyby(food);
       String foodtype=apss.getFoodtype();
       String urlpath=apss.getUrlpath();
       String description=apss.getDescription();
       String belong=apss.getBelong();
       String createtime=apss.getCreatetime();
       String opcreate=apss.getOpcreate();
       fss.insertt(food,foodtype,urlpath,description,opcreate,createtime,belong);
       aps.delee(food);
       return "ok";
    }
    @ResponseBody
    @RequestMapping("/notpass")
    public String notpass(@RequestBody Map<String,Object>map){
        System.out.println(map);
        String food= (String) map.get("food");
        System.out.println(food);
        aps.delee(food);
        return "ok";
    }
}
