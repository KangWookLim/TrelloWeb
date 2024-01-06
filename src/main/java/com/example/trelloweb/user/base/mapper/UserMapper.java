package com.example.trelloweb.user.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int checkEmail(@Param("EMAIL") String email);
}
