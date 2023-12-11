package com.example.trelloweb.mail.controller;

import com.example.trelloweb.mail.service.MailService;
import com.example.trelloweb.mail.vo.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/mail")
    @ResponseBody
    public void MailSend(@RequestBody String email){
        System.out.println(email);
        mailService.CreateMail(email);
    }

}