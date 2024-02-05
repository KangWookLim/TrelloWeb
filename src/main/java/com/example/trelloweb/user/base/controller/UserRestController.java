package com.example.trelloweb.user.base.controller;

import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.base.form.ProfileForm;
import com.example.trelloweb.user.base.service.UserService;
import com.example.trelloweb.user.base.vo.UserinfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PutMapping("/profile/update")
    public UserVo updateprofile(@RequestBody Map<String, Object> data_map, Principal principal) {
        System.out.println(data_map);
        UserVo userVo = userService.findByUSER_UID(principal.getName()).orElse(null);
        userVo.setUseruid((String)data_map.get("useruid"));
        userVo.setFULLNAME((String)data_map.get("fullName"));
        userVo.setBIRTH((String)data_map.get("BIRTH"));
        userVo.setBIO((String)data_map.get("BIO"));
        userVo.setSOCIALLINK1((String)data_map.get("SOCIALLINK1"));
        userVo.setSOCIALLINK2((String)data_map.get("SOCIALLINK2"));
        userVo.setSOCIALLINK3((String)data_map.get("SOCIALLINK3"));
        userVo.setSOCIALLINK4((String)data_map.get("SOCIALLINK4"));
        return userService.updateUser(userVo);
    }

    @PostMapping("/passcheck")
    public boolean passcheck(@RequestParam("password") String password, Principal principal){
        UserVo userVo = userService.findByUSER_UID(principal.getName()).orElse(null);
        return passwordEncoder.matches(password, userVo.getPW());
    }

    @PostMapping("/change/pass")
    public void changePass(@RequestParam("PrivateData") String PrivateData){
        System.out.println(PrivateData);
    }

    @PostMapping("/change/id")
    public void changeId(@RequestParam("PrivateData") String PrivateData){
        System.out.println(PrivateData);
    }

    @PostMapping("/change/nickname")
    public void changeNickname(@RequestParam("PrivateData") String PrivateData){
        System.out.println(PrivateData);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam("PrivateData") String Private){
        System.out.println(Private);
        return true;
    }
}
