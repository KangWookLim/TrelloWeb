package com.example.trelloweb.user.base.service;

import com.example.trelloweb.user.base.repo.UserinfoRepo;
import com.example.trelloweb.user.base.vo.UserinfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserinfoRepo userinfoRepo;

    public UserinfoVo findinfoById(String id) {
        return userinfoRepo.findByUseruid(id).orElse(null);
    }
}
