package com.example.phone.Service;

import com.example.phone.Mapper.fooddetailMapper;
import com.example.phone.dao.fooddetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fooddetailServiceImpl implements fooddetailService {
    @Autowired
    private fooddetailMapper FooddetailMapper;

    /**
     * @param ligengxian 查找菜式的详情页
     */
    @Override
    public fooddetail finddetail(fooddetail Fooddetail) {
        return FooddetailMapper.SelectFood(Fooddetail);
    }

    @Override
    public boolean selet(String food) {
        boolean falg=false;
        System.out.println("eeee"+food);
        try {
            FooddetailMapper.Updatee(food);
            falg=true;
            return falg;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return falg;
    }

    @Override
    public List<fooddetail> sel() {
        return FooddetailMapper.SelectFoodtop4();
    }

    @Override
    public void insertt(String food, String foodtype, String urlpath, String description, String opcreate, String createtime, String belong) {
        FooddetailMapper.Insertt(food,foodtype,urlpath,description,opcreate,createtime,belong);
    }
}
