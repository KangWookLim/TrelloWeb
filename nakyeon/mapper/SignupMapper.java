package com.example.trelloweb.signup.mapper;


import com.example.trelloweb.signup.vo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SignupMapper {
    int checkToken(@Param("token") String token);

    int insertToken(@Param("email") String email, @Param("token") String token);

    List<Users> findAllMembers();
}
