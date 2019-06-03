package com.example.phone.Mapper;

import com.example.phone.dao.fooddetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassificationMapper {
    /**
     * 显示家常菜的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodJia(String foodtype);
    /**
     * 显示早餐的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodZao(String foodtype);
    /**
     * 显示凉菜的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodliang(String foodtype);
    /**
     * 显示烘焙的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodhong(String foodtype);
    /**
     * 显示瘦身的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodshou(String foodtype);
    /**
     * 显示养生的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodyang(String foodtype);
    /**
     * 显示海鲜的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodhai(String foodtype);
    /**
     * 显示靓汤的样式
     */
    @Select("select * from fooddetail where foodtype=#{foodtype}")
    List<fooddetail> SelectFoodtang(String foodtype);
    /**
     * 显示详情
     */
    @Select("select * from fooddetail where food=#{food}")
    fooddetail SelectFooddetail(String food);
}
