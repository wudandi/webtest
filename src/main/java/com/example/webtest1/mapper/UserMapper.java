package com.example.webtest1.mapper;

import com.example.webtest1.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //
    @Insert("insert into user (point,explanation) values (#{point},#{explanation})")
    void adduser(User user);

    @Select("select * from user where point=#{point}")
    User getuser(String point);

    @Delete("delete from user where point=#{point}")
    void deleteuser(String point);

    @Update("update user set explanation=#{explanation} where point=#{point}")
    void updateuser(String point,String explanation);

    @Select("select * from user")
    List<User> getallusers();
}
