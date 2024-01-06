package com.example.trelloweb.mail.controller;

import com.example.trelloweb.mail.service.MailService;
import com.example.trelloweb.signup.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final SignupService signupService;

    @RequestMapping("/mail")
    @ResponseBody
    public void MailSend(@RequestBody String email){
        System.out.println(email);
        String token = mailService.createtoken();

        signupService.insertToken(email, token);
        mailService.CreateMail(email, token);
    }

    @GetMapping ("/emailSent")
    public ModelAndView emailSent() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/signup/emailSent");
        return view;
    }



}