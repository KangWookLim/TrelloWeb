package com.example.trelloweb.signup.controller;

import com.example.trelloweb.signup.service.SignupService;
import com.example.trelloweb.signup.vo.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @RequestMapping ("/startSign")
    public ModelAndView startSignPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/signup/startSign");
        return view;
    }
    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/signup/signUp");
        return view;
    }
    @RequestMapping("/signup/chkToken")
    @ResponseBody
    public int checkToken(@RequestParam(name="token") String token) throws Exception {
        System.out.println(token);
        return signupService.checkToken(token);
        
    }
    @RequestMapping("/signup/chkID")
    @ResponseBody
    public int checkID(@RequestParam(name="ID") String ID) throws Exception {
        return signupService.checkID(ID);
    }

    @RequestMapping ("/signup/findAllMembers")
    @ResponseBody
    public List<Users> findAllMembers() throws Exception {
        List<Users> AllUsers = signupService.findAllMembers();
        return AllUsers;
    }

}
