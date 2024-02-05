package com.example.trelloweb.user.base.controller;

import com.example.trelloweb.user.Blocked_User.entity.Blocked_UserVo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.base.form.ProfileForm;
import com.example.trelloweb.user.base.repo.UserJPAClassRepo;
import com.example.trelloweb.user.base.service.UserInfoService;
import com.example.trelloweb.user.base.service.UserService;
import com.example.trelloweb.user.base.vo.UserinfoVo;
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

    @GetMapping("/profile/U{useruid}")
    public ModelAndView userProfile(@PathVariable("useruid") String useruid, Principal principal){
        ModelAndView view = new ModelAndView();
        UserinfoVo userinfoVo = userInfoService.findinfoById(useruid);
        ProfileForm profileForm = ProfileForm.builder()
                .FullName(userinfoVo.getFULLNAME())
                .SOCIALLINK1(userinfoVo.getSOCIALLINK1())
                .SOCIALLINK2(userinfoVo.getSOCIALLINK2())
                .SOCIALLINK3(userinfoVo.getSOCIALLINK3())
                .SOCIALLINK4(userinfoVo.getSOCIALLINK4())
                .BIO(userinfoVo.getBIO())
                .BIRTH(userinfoVo.getBIRTH())
                .build();
        if(useruid.equals(principal.getName())){
            view.addObject("blockedUserList", userJPAClassRepo.findBlockedUserInfoByUserUid(useruid));
        }
        view.addObject("userInfo", userinfoVo);
        view.addObject("profileForm",profileForm);
        view.setViewName("views/profile/profile");
        return view;
    }
}
