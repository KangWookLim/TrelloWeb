package com.example.trelloweb.signup.service;

import com.example.trelloweb.signup.mapper.SignupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final SignupMapper signupMapper;

    public int checkToken(String token) {
        int result = signupMapper.checkToken(token);
        System.out.println(result);
        return result;
    }



}
