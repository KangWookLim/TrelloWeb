package com.example.trelloweb.signup.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignupMapper {
    int checkToken(@Param("token") String token);


}
