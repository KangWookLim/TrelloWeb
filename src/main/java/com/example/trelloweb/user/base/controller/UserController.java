package com.example.trelloweb.user.base.controller;

import com.example.trelloweb.user.Blocked_User.entity.Blocked_UserVo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.base.form.ProfileForm;
import com.example.trelloweb.user.base.repo.UserJPAClassRepo;
import com.example.trelloweb.user.base.service.UserInfoService;
import com.example.trelloweb.user.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserInfoService userInfoService;
    private final UserJPAClassRepo userJPAClassRepo;

    @GetMapping("/profile")
    public ModelAndView userProfile(Principal principal, ProfileForm profileForm){
        ModelAndView view = new ModelAndView();
        UserVo user = userService.findByUSER_UID(principal.getName()).orElse(null);
        view.addObject("userInfo", userInfoService.findinfoById(principal.getName()));
        view.addObject("blockedUserList", userJPAClassRepo.findBlockedUserInfoByUserUid(principal.getName()));
        view.addObject("profileForm",profileForm);
        view.setViewName("views/profile/profile");
        return view;
    }
}
