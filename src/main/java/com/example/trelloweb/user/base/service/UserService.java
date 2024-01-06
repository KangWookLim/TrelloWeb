package com.example.trelloweb.user.base.service;


import com.example.trelloweb.user.base.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public int checkEmail(String email) {
        int result = userMapper.checkEmail(email);
        System.out.println(result);
        return result;
    }

}
