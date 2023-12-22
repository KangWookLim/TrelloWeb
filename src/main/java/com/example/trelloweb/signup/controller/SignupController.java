package com.example.trelloweb.signup.controller;

import com.example.trelloweb.signup.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @RequestMapping ("/startSign")
    public ModelAndView startSignPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/startSign");
        return view;
    }
    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/signup");
        return view;
    }
    @RequestMapping("/signup/chkToken")
    @ResponseBody
    public int checkToken(@RequestParam(name="token") String token) throws Exception {
        System.out.println(token);
        return signupService.checkToken(token);
        
    }
}
