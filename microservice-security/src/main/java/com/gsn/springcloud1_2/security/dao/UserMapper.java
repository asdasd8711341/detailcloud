package com.gsn.springcloud1_2.security.dao;

import com.gsn.springcloud1_2.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    public User queryUserByUserName(String username);
}