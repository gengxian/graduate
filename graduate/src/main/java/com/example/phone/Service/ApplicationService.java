package com.example.phone.Service;

import com.example.phone.dao.application;

import java.util.List;

public interface ApplicationService {
    //food,foodtype,createtime,description,opcreate,urlpath,belong
    void  insertapplication(String food,String foodtype,String createtime,String description,String opcreate,String urlpath,String belong);
    List<application>chakan();
    application seleceonly(String food);
    application seleceonlyby(String food);
    void delee(String food);
}
