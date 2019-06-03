package com.example.phone.Json;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JsonCommon {
    /*
    成功的时候返回的数据
     */
    public Map<String, String> SucessRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        map.put("code", "200");
        map.put("请求", "成功");
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("status","ok");
//        jsonObject.put("code","200");
//        jsonObject.put("请求","成功");
        return map;
    }

    /**
     * 失败时候返回的数据
     */
    public Map<String, String> FailRequest() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "fail");
        map.put("code", "400");
        map.put("请求", "失败");

        return map;
    }
}

