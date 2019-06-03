package com.example.phone.controller;

import com.example.phone.Service.CommentService;
import com.example.phone.Service.loginService;
import com.example.phone.dao.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这里主要负责评论模块的开发
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private loginService loginservice;
    /**
     * 用户发表的评论
     */
    @ResponseBody
   @RequestMapping("/commentme")
   public String  bycommentmeuser(@RequestBody Map<String,Object>map)
   {
       System.out.println(map);
       //获取菜式的名字
       String food= (String) map.get("food");
       String nickname= (String) map.get("nickname");
       //获取评论的内容
       String commentme= (String) map.get("commentme");
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       String day=   df.format(new Date());
     //将数据存放进数据库中
       commentService.insertcomment(food,commentme,day,nickname);
       return food;
   }
    /**
     * 显示该菜式的所有的评论
     */
    @ResponseBody
    @RequestMapping("/commentall")
    public List<comment> selectallomment(@RequestBody Map<String,Object>map){
        String food= (String) map.get("food");
        System.out.println(food);
       List<comment> li= commentService.slectrall(food);
        return  li;
    }
    /**
     * 通过token获取该用户的昵称
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/nickname")
    public Map<String,String> getnickname(@RequestBody Map<String,Object>map){
        System.out.println(map);
        String openid= (String) map.get("token");
        String nickname= loginservice.selectnickname(openid);
        Map<String,String> map1=new HashMap<>();
        map1.put("nickname",nickname);
        return map1;
    }
}
