package com.example.trelloweb.user.signup.service;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.vo.UserVo;
import com.example.trelloweb.user.signup.repo.SignUpRepo;
import com.example.trelloweb.user.signup.vo.SignupVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserJpaRepo userJpaRepo;
    private final SignUpRepo signUpRepo;
    private final PasswordEncoder passwordEncoder;

    public UserVo creat(String ID, String PW, String NICKNAME, String FULLNAME,
                        String Email, String Birth, String gender, String PHONE, String Bio) {
                UserVo user = new UserVo();
                user.setID(ID);
                user.setPW(passwordEncoder.encode(PW));
                user.setNICKNAME(NICKNAME);
                user.setFULLNAME(FULLNAME);
                user.setEMAIL(Email);
                user.setBIRTH(Birth);
                user.setGENDER(gender);
                user.setPHONE(PHONE);
                user.setBIO(Bio);
                user.setCREATE_DATE(LocalDateTime.now());
                user.setUPDATE_DATE(LocalDateTime.now());
                userJpaRepo.save(user);
                return user;
    }

    public int idDuplicateCheck(String id){
        return signUpRepo.idduplicatCheck(id);
    }

    public int nicknameCheck(String nickname){
        return signUpRepo.nickduplicatCheck(nickname);
    }

    public int phoneCheck(String phone){
        return signUpRepo.phoneduplicatCheck(phone);
    }

    public int checkEmail(String email) {
        return signUpRepo.checkEmail(email);
    }
}
