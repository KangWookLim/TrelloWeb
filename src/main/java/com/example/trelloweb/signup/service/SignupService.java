package com.example.trelloweb.signup.service;

import com.example.trelloweb.signup.mapper.SignupMapper;
import com.example.trelloweb.signup.repo.SignupRepo;
import com.example.trelloweb.signup.vo.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final SignupMapper signupMapper;
    private final SignupRepo signupRepo;

    public int checkToken(String token) {
        int result = signupMapper.checkToken(token);
        System.out.println(result);
        return result;
    }

    public int insertToken(String email, String token) {
        System.out.println("token = " + token);
        System.out.println("email = " + email);

        return signupMapper.insertToken(email, token);
    }

    public int checkID(String ID) {
        return signupRepo.findByID(ID);
    }


    public List<Users> findAllMembers() {
        return signupMapper.findAllMembers();
    }
}
