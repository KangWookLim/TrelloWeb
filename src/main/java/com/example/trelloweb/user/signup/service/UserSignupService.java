package com.example.trelloweb.user.signup.service;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.signup.repo.SignUpRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserJpaRepo userJpaRepo;
    private final SignUpRepo signUpRepo;
    private final PasswordEncoder passwordEncoder;

    public void creat(String ID, String PW, String email, String NICKNAME, String FULLNAME,
                      String Birth, String Bio) {
                UserVo user = new UserVo();
                user.setID(ID);
                user.setPW(passwordEncoder.encode(PW));
                user.setEMAIL(email);
                user.setNICKNAME(NICKNAME);
                user.setFULLNAME(FULLNAME);
                user.setBIRTH(Birth);
                user.setBIO(Bio);
                user.setCREATEDATE(LocalDateTime.now());
                user.setUPDATEDATE(LocalDateTime.now());
                userJpaRepo.save(user);
    }

    public void OAuth2create(String UID ,String ID, String PW, String email, String NICKNAME, String FULLNAME,
                             String Birth, String Bio, String IMGURL){
        UserVo user = new UserVo();
        user.setUseruid(UID);
        user.setID(ID);
        user.setEMAIL(email);
        user.setPW(passwordEncoder.encode(PW));
        user.setNICKNAME(NICKNAME);
        user.setFULLNAME(FULLNAME);
        user.setIMGURL(IMGURL);
        user.setBIRTH(Birth);
        user.setBIO(Bio);
        user.setCREATEDATE(LocalDateTime.now());
        user.setUPDATEDATE(LocalDateTime.now());
        userJpaRepo.save(user);
    }


    public int nicknameCheck(String nickname){
        return signUpRepo.nickduplicatCheck(nickname);
    }

    public int checkEmail(String email) {
        return signUpRepo.checkEmail(email);
    }

    public int IDduplicateCheck(String id){ return signUpRepo.IDduplicateCheck(id); }
}
