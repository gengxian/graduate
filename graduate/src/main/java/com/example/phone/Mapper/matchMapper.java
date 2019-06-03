package com.example.phone.Mapper;

import com.example.phone.dao.matchh;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface matchMapper {
    /**
     * 将openid和食物名存放进数据库中
     * @param openid
     * @param food
     */
    @Insert("insert into matchh(openid,food) values(#{openid},#{food})")
    void addliulan(matchh Match);
    /**
     * 查询是否存在该浏览记录，有的话就不进行数据的插入
     */
    @Select("select * from matchh where openid=#{openid}and food=#{food}")
    List<matchh>selectfood(matchh Matchh);
    /**
     * 通过openid取出浏览记录
     */
    @Select("select * from matchh where openid=#{openid}")
    List<matchh>select2(String openid);
}
