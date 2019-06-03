package com.example.phone.Service;

import com.example.phone.Mapper.foodAll;
import com.example.phone.Mapper.matchMapper;
import com.example.phone.dao.fooddetail;
import com.example.phone.dao.matchh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class foodAllServiceImpl implements foodAllService {
    @Autowired
    private matchMapper mm;
   @Autowired
    private foodAll FoodAll;


    @Override
    public List<fooddetail> SelectFood(String belong) {
        return FoodAll.SelectFood(belong);
    }

    @Override
    public List<fooddetail> SelectFoodtop10() {
        return FoodAll.SelectFoodtop10();
    }

    @Override
    public List<matchh> selectfenzu() {
        return FoodAll.slecrfenzu();
    }

    @Override
    public List<matchh> sele(String openid) {
        return mm.select2(openid);
    }

    @Override
    public fooddetail selet(String food) {
        return FoodAll.SelectFo(food);
    }
}
