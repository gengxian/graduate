package com.example.phone.Mapper;

import com.example.phone.dao.application;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    /**
     * 将数据存进来
     */
    @Insert("insert into application(food,foodtype,createtime,description,opcreate,urlpath,belong)values(#{food},#{foodtype},#{createtime},#{description},#{opcreate},#{urlpath},#{belong})")
    void insertapplication(@Param("food") String food,
                           @Param("foodtype") String foodtype,
                           @Param("createtime") String createtime,
                           @Param("description") String description,
                           @Param("opcreate") String opcreate,
                           @Param("urlpath") String urlpath,
                           @Param("belong") String belong);
    @Select("select * from application")
    List<application>chakan();
    @Select("select * from application where food=#{food}")
    application seleonly(@Param("food")String food);
    @Select("select * from application where food=#{food}")
    application chakanonly(@Param("food")String food);
    @Delete("delete from application where food=#{food}")
    void dele(@Param("food")String food);
}
