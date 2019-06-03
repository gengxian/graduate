package com.example.phone.Mapper;


import com.example.phone.dao.fooddetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface fooddetailMapper {
    /**
     * 菜式详情页
     */
    @Select("select * from fooddetail where food=#{food}")
    fooddetail SelectFood(fooddetail Fooddetail);
    /**
     * 将菜式的sumfoodtype加一
     */
    @Update("update fooddetail set sumfoodtype =sumfoodtype+1 where food=#{foo}")
    void Updatee(String foo);

    @Select("select food from fooddetail order by sumfoodtype desc limit 0,4 ")
    List<fooddetail> SelectFoodtop4();
    @Insert("insert into fooddetail(food,foodtype,urlpath,description,belong,createtime,opcreate)values(#{food}," +
            "#{foodtype},#{urlpath},#{description},#{belong},#{createtime},#{opcreate})")
    void Insertt(@Param("food")String food,@Param("foodtype")String foodtype,@Param("urlpath")String urlpath,@Param("description")String description,
                 @Param("belong")String beelong,@Param("createtime")String createtime,@Param("opcreate")String opcreate);

}
