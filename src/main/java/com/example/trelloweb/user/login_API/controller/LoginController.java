package com.example.trelloweb.user.login_API.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

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
    @PostMapping("/check")
    @ResponseBody
    public void check(@RequestParam Map<String,Objects> params){
        System.out.println(params);
    }
}
