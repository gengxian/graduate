package com.example.phone.Service;

import com.example.phone.dao.fooddetail;

import java.util.List;


public interface fooddetailService {
    /**
     * @param ligengxian 查找菜式的详情页
     */
    fooddetail finddetail(fooddetail Fooddetail);
    /**
     * @param ligengxian
     * 根据菜名数量加一
     */
    boolean selet(String food);
    List<fooddetail>sel();

    void insertt(String food,String foodtype,String urlpath,String description,String opcreate,String createtime,String belong);

}
