package com.example.phone.Service;

import com.example.phone.dao.fooddetail;
import com.example.phone.dao.matchh;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface foodAllService {
    /**
     * 菜式总的页面,通过当前定位的城市来获取该城市的菜式
     */
    List<fooddetail> SelectFood(String belong);
    /**
     * 显示评分最高的前十条数据
     */
    List<fooddetail>SelectFoodtop10();
    /**
     * 显示用户分组浏览数据
     */
    List<matchh>selectfenzu();
    /**
     * 通过openid查询该用户的浏览记录
     */
    List<matchh>sele(String openid);
    fooddetail selet(String food);
}
