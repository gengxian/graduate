package com.example.phone.Service;

import com.example.phone.Mapper.ApplicationMapper;
import com.example.phone.dao.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicaionServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationMapper am;
    @Override
    //food,foodtype,createtime,description,opcreate,urlpath,belong
    public void insertapplication(String food, String foodtype, String createtime, String description, String opcreate,String urlpath, String belong) {
       am.insertapplication(food,foodtype,createtime,description,opcreate,urlpath,belong);
    }

    @Override
    public List<application> chakan() {
        return am.chakan();
    }

    @Override
    public application seleceonly(String food) {
        return am.seleonly(food);
    }

    @Override
    public application seleceonlyby(String food) {
        return am.chakanonly(food);
    }

    @Override
    public void delee(String food) {
        am.dele(food);
    }
}
