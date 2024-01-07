package com.example.trelloweb.user.signup.service;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserJpaRepo userJpaRepo;
    private final PasswordEncoder passwordEncoder;

    public UserVo creat(String ID, String PW, String IMG_URL, String NICKNAME, String FULLNAME,
                        String Email, String Birth, char gender, String PHONE, String Bio,
                        String SOCIAL_LINK_1, String SOCIAL_LINK_2, String SOCIAL_LINK_3, String SOCIAL_LINK_4) {
                UserVo user = new UserVo();
                user.setID(ID);
                user.setPW(passwordEncoder.encode(PW));
                user.setIMG_URL(IMG_URL);
                user.setNICKNAME(NICKNAME);
                user.setFULLNAME(FULLNAME);
                user.setEMAIL(Email);
                user.setBIRTH(Birth);
                user.setGENDER(gender);
                user.setPHONE(PHONE);
                user.setBIO(Bio);
                user.setSOCIAL_LINK_1(SOCIAL_LINK_1);
                user.setSOCIAL_LINK_2(SOCIAL_LINK_2);
                user.setSOCIAL_LINK_3(SOCIAL_LINK_3);
                user.setSOCIAL_LINK_4(SOCIAL_LINK_4);
                user.setCREATE_DATE(LocalDateTime.now());
                user.setUPDATE_DATE(LocalDateTime.now());
                userJpaRepo.save(user);
                return user;
    }
}
