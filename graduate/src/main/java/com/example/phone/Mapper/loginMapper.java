package com.example.phone.Mapper;

import com.example.phone.dao.login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface loginMapper {
    /**
     * 添加用户信息
     *
     * @param Login
     */
    @Insert("insert into login(openid,nickname,picture,province,city) values(#{openid},#{nickname},#{picture},#{province},#{city})")
    void addUser(login Login);

    /**
     * 查找用户信息
     */
    @Select("select * from login where openid=#{openid}")
    login SelectUser(login Login);
    /**
     * 查找用户昵称信息
     */
    @Select("select nickname from login where openid=#{open id}")
    String Selectnickname(@Param("openid") String openid);


}
