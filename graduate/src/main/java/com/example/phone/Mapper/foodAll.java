package com.example.phone.Mapper;

import com.example.phone.dao.fooddetail;
import com.example.phone.dao.matchh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface foodAll {
    /**
     * 菜式总的页面,通过当前定位的城市来获取该城市的菜式
     */
    @Select("select * from fooddetail where belong=#{belong}")
      List<fooddetail> SelectFood(String belong);
    /**
     * 显示当前评论最高的前十条数据
     */
    @Select("select * from fooddetail order by oprecommend desc limit 0,10 ")
    List<fooddetail> SelectFoodtop10();
    /**
     * 根据openid分组显示用户数据
     */
    @Select("SELECT openid, GROUP_CONCAT(food) AS food FROM matchh GROUP BY openid;")
    List<matchh>slecrfenzu();
    /**
     * 菜式详情页
     */
    @Select("select * from fooddetail where food=#{food}")
    fooddetail SelectFo(String food);
}
