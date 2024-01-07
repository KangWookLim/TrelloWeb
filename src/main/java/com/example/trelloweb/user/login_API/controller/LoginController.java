package com.example.trelloweb.user.login_API.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/login/login");
        return view;
    }
}
