package com.example.spbthy.mapper;

import com.example.spbthy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //用户登录
    @Select("select id,name,password,age from user where name = #{name} and password = #{password}")
    public User userLogin(@Param("name")String name, @Param("password")String password);

    //注册新用户
    @Insert("insert into user (name,password,age) values (#{name},#{password},#{age})")
    public int addUser(@Param("name")String name,@Param("password")String password,@Param("age")int age);
}
