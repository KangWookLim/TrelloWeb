package com.example.trelloweb.user.base.controller;

import com.example.trelloweb.user.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @RequestMapping("/profile")
    public ModelAndView userProfile(Principal principal){
        ModelAndView view = new ModelAndView();
        view.setViewName("views/profile/profile");
        return view;
    }

    @RequestMapping("/editProfile")
    public ModelAndView editProfile(Principal principal){
        ModelAndView view = new ModelAndView();
        view.setViewName("views/profile/editProfile");
        return view;
    }
}
