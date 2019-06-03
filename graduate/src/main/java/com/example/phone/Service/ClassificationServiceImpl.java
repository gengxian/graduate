package com.example.phone.Service;

import com.example.phone.Mapper.ClassificationMapper;
import com.example.phone.dao.fooddetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
  private ClassificationMapper classificationMapper;
    @Override
    public List<fooddetail> SelectFoodjia(String foodtype) {
        return classificationMapper.SelectFoodJia(foodtype);
    }

    @Override
    public List<fooddetail> SelectFoodzao(String foodtype) {
        System.out.println("我进来服务层了没");
        return classificationMapper.SelectFoodZao(foodtype);
    }

    @Override
    public List<fooddetail> SelectFoodliang(String foodtype) {
        return classificationMapper.SelectFoodliang(foodtype);
    }

    @Override
    public List<fooddetail> SelectFoodhong(String foodtype) {
        return classificationMapper.SelectFoodhong(foodtype);
    }

    @Override
    public List<fooddetail> SelectFoodshou(String foodtype) {
        return classificationMapper.SelectFoodshou(foodtype);
    }

    @Override
    public List<fooddetail> SelectFoodyang(String foodtype) {
        return classificationMapper.SelectFoodyang(foodtype);
    }

    @Override
    public List<fooddetail> SelectFoodhai(String foodtype) {
        return classificationMapper.SelectFoodhai(foodtype);
    }

    @Override
    public List<fooddetail> SelectFoodtang(String foodtype) {
        return classificationMapper.SelectFoodtang(foodtype);
    }

    @Override
    public fooddetail SelectFoodDetail0(String food) {
        return classificationMapper.SelectFooddetail(food);
    }
}
