package com.example.phone.Mapper;

import com.example.phone.dao.comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {


    //将用户的评论数据插进数据库中
    @Insert("insert into comment(food,commentme,day,nickname)values(#{food},#{commentme},#{day},#{nickname})")
    void insercomment(@Param("food")String food,@Param("commentme")String commentme,@Param("day")String day,@Param("nickname")String nickname);
    @Select("select * from comment where food=#{food}order by day desc")
    List<comment>selecrall(@Param("food")String food);
}
