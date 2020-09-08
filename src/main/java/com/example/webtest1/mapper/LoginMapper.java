package com.example.webtest1.mapper;

import com.example.webtest1.model.Login;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoginMapper {
    @Insert("insert into login (username,password) values (#{username},#{password})")
    void addlogin(Login login);

    @Select("select * from login where username=#{username}")
    Login getlogin(String username);

    @Select("select * from login where username=#{username} and password=#{password}")
    Login userlogin(String username, String password);

    @Delete("delete from login where username=#{username}")
    void deletelogin(String username);

    @Update("update login set password=#{password} where username=#{username}")
    void updatelogin(String username,String password);
}
