package com.example.trelloweb.mail.service;

import com.example.trelloweb.mail.vo.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    private static final String senderEmail= "cnakyeon@gmail.com";

    public void CreateMail(String email){
        System.out.println(email + "님에게 이메일을 보냈습니다.");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email); // 받는 사람의 이메일 주소 설정
        message.setFrom(senderEmail);
        message.setSubject("trello 본인확인 이메일입니다");
        message.setText("본인이 맞으십니까?");
        javaMailSender.send(message);
    }
}
