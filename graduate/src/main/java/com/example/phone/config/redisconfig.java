package com.example.phone.config;


import com.example.phone.dao.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class redisconfig {
    @Autowired
    private StringRedisTemplate redisTpl;

    /**
     * 功能描述：设置key-value到redis中
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        try {
            redisTpl.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //获取用户并将用户的信息存进redis中
    public Boolean List(login Login) {
        System.out.println("我想进来redis");
        String key = Login.getOpenid();
        System.out.println(key);
        try {
            redisTpl.opsForList().rightPush(key, Login.getOpenid());
            redisTpl.opsForList().rightPush(key, Login.getNickname());
            redisTpl.opsForList().rightPush(key, Login.getPicture());
            redisTpl.opsForList().rightPush(key, Login.getProvince());
            redisTpl.opsForList().rightPush(key, Login.getCity());
            List<String> red = redisTpl.opsForList().range(key, 0, -1);

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }


    }

    /**
     * 通过openid将redis中的指定的用户提取出来进行显示
     */
    public Map<String, String> selectUser(login Login) {
        String openid = Login.getOpenid();
        //将redis对应的数据拿出来
        String openid0 = redisTpl.opsForList().index(openid, 0);
        String nickname = redisTpl.opsForList().index(openid, 1);
        String picture = redisTpl.opsForList().index(openid, 2);
        String province = redisTpl.opsForList().index(openid, 3);
        String city = redisTpl.opsForList().index(openid, 4);
        Map<String, String> map = new HashMap<>();
        map.put("openid", openid0);
        System.out.println(openid0);
        map.put("nickname", nickname);
        System.out.println(nickname);
        map.put("picture", picture);
        System.out.println(picture);
        map.put("province", province);
        map.put("city", city);

        return map;
    }


}