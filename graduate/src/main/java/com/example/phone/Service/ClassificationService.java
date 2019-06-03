package com.example.phone.Service;

import com.example.phone.dao.fooddetail;

import java.util.List;

public interface ClassificationService {
    /**
     * 菜式家常菜
     */
    List<fooddetail> SelectFoodjia(String foodtype);
    /**
     * 菜式早餐
     */
    List<fooddetail> SelectFoodzao(String foodtype);
    /**
     * 菜式凉菜
     */
    List<fooddetail> SelectFoodliang(String foodtype);
    /**
     * 菜式烘焙
     */
    List<fooddetail> SelectFoodhong(String foodtype);
    /**
     * 菜式瘦身
     */
    List<fooddetail> SelectFoodshou(String foodtype);
    /**
     * 菜式养生
     */
    List<fooddetail> SelectFoodyang(String foodtype);
    /**
     * 菜式海鲜
     */
    List<fooddetail> SelectFoodhai(String foodtype);
    /**
     * 菜式靓汤
     */
    List<fooddetail> SelectFoodtang(String foodtype);
    /**
     * 菜式详情
     */
    fooddetail SelectFoodDetail0(String food);
}
