package com.example.trelloweb.mail.controller;

import com.example.trelloweb.mail.service.MailService;
import com.example.trelloweb.mail.vo.Mail;
import com.example.trelloweb.signup.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final SignupService signupService;
    @PostMapping("/mail")
    @ResponseBody
    public void MailSend(@RequestBody String email){
        System.out.println(email);
        String token = UUID.randomUUID().toString();

        signupService.insertToken(email, token);
        mailService.CreateMail(email, token);
    }

}