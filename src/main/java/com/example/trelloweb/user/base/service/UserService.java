package com.example.trelloweb.user.base.service;


import com.example.trelloweb.user.base.mapper.UserMapper;
import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserJpaRepo userJpaRepo;

    public int checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    public Optional<UserVo> findByUSER_UID(String user_uid) {
        return userJpaRepo.findById(user_uid);
    }

}
