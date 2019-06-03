package com.example.phone.controller;


import com.example.phone.Service.loginService;
import com.example.phone.config.redisconfig;
import com.example.phone.dao.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private redisconfig RedisConfig;
    @Autowired
    private loginService loginservice;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;
    @Value("${wx.url}")
    private String url;

    @ResponseBody
    @RequestMapping(value = "/appid", method = RequestMethod.POST)
    //用code来换取appid和secret和接口
    public Map<String, String> loginn(@RequestParam("code") String code) {
        //如果是空值，不能进行下去
        if (code == "" || code == null || code.isEmpty()) {
            System.out.println("我是空值");
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "参数不能为空");
            map.put("status", "fail");
            return map;
        } else {
            System.out.println(code);
            HashMap<String, String> map1 = new HashMap<>();
            map1.put("appid", appid);
            map1.put("secret", secret);
            map1.put("url", url);
            return map1;
        }

    }

    //将新用户信息存放进数据库和redis中
    @ResponseBody
    @PostMapping(value = "/adduser", produces = "application/json;charset=UTF-8")
    public Map<String, Object> Add(@RequestBody login Login) {
//     System.out.println(nickname);
        System.out.println("我进来了没");
        System.out.println(Login.getPicture());

        boolean flag = loginservice.AddUser(Login);
//        boolean redis = RedisConfig.List(Login);
        if (flag == true) {

            //拿取openid对应的数据的信息
//            Map<String, String> selectmap = RedisConfig.selectUser(Login);
            login lo=loginservice.SelectUser(Login);
            Map<String,Object>selectmap1=new HashMap<>();
            selectmap1.put("openid",lo.getOpenid());
            selectmap1.put("nickname",lo.getNickname());
            selectmap1.put("picture",lo.getPicture());
            selectmap1.put("city",lo.getCity());
            selectmap1.put("province",lo.getProvince());

            return selectmap1;
        } else {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("error", "添加数据失败");
            map1.put("status", "fail");
            return map1;
        }
    }

    /**
     * 已经授权过了，通过token查找redis将数据取出来进行显示
     *
     * @param Login
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/selectuser", produces = "application/json;charset=UTF-8")
    public Map<String, Object> SelectUser(@RequestBody login Login) {
        //判断是否为空
        String openid = Login.getOpenid();
        if (openid == "" || openid == null) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("error", "c查找数据失败数据失败");
            map1.put("status", "fail");
            return map1;
        }
        //拿取openid对应的数据的信息
//        Map<String, String> selectmap = RedisConfig.selectUser(Login);
        login lo=loginservice.SelectUser(Login);
        Map<String,Object>selectmap1=new HashMap<>();
        selectmap1.put("openid",lo.getOpenid());
        selectmap1.put("nickname",lo.getNickname());
        selectmap1.put("picture",lo.getPicture());
        selectmap1.put("city",lo.getCity());
        selectmap1.put("province",lo.getProvince());

        return selectmap1;
    }


}
