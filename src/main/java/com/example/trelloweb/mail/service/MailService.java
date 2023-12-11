package com.example.trelloweb.mail.service;

import com.example.trelloweb.mail.vo.Mail;
import com.example.trelloweb.signup.mapper.SignupMapper;
import com.example.trelloweb.signup.vo.Signuptoken;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    private static final String senderEmail= "cnakyeon@gmail.com";
    private final SignupMapper signupMapper;
    public void CreateMail(String email){
        System.out.println(email + "님에게 이메일을 보냈습니다.");
        //String token = UUID.randomUUID().toString();

        //여기에서 토큰 저장 시작

        MimeMessagePreparator preparatory = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            String username = email.split("@")[0];
            String content = "<!DOCTYPE html>\n" +
                    "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <script src=\"https://code.jquery.com/jquery-3.6.4.js\"></script>\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div id=\":18w\" class=\"ii gt\" jslog=\"20277; u014N:xr6bB; 1:WyIjdGhyZWFkLWY6MTc3ODc5MTU1MTM4Nzk0MjMwOCJd; 4:WyIjbXNnLWY6MTc3ODc5MTU1MTM4Nzk0MjMwOCJd\"><div id=\":18x\" class=\"a3s aiL msg2214859210816409612\"><u></u>\n" +
                    "    <div style=\"margin:0;padding:0;font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Fira Sans,Droid Sans,Helvetica Neue,sans-serif;font-size:14px;font-weight:400;letter-spacing:-0.005em;color:#091e42;line-height:20px;background:#ffffff;height:100%;width:100%\"><span style=\"display:none!important;font-size:1px;color:#ffffff;line-height:1px;max-height:0px;max-width:0px;opacity:0;overflow:hidden\">Hi " +
                    username +
                    ", you're nearly there! Before you get started using <span class=\"il\">Trello</span>, let us know we've got the correct email for you. Your Atlassian Account. Make things easier by using one account across all of your Atlassian products. Learn more. This message was sent to you by Atlassian Cloud.</span><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse\"><tbody><tr><td align=\"center\"><div style=\"max-width:520px;margin:0 auto\"><div style=\"vertical-align:top;text-align:left;font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Fira Sans,Droid Sans,Helvetica Neue,sans-serif;font-size:14px;font-weight:400;letter-spacing:-0.005em;color:#091e42;line-height:20px\"><div style=\"padding-top:30px;padding-bottom:20px;vertical-align:top;text-align:center\"><a href=\"https://www.atlassian.com/software/trello\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.atlassian.com/software/trello&amp;source=gmail&amp;ust=1702340657045000&amp;usg=AOvVaw2tp41WEURCnAZAHqp_TRiq\"><img src=\"https://ci3.googleusercontent.com/meips/ADKq_Nad7XNCtSOr10IERUCtm6I547fGFvOORDnBAedDV4OYkvpZ4mmrLVDDg9fp3s11CCjUsOb9UN0WFd1qTDok6xiyJWVxwnbWSQ_hC8_R9IwqwFtlkMNAFb5xUOh_zAmQeP08SgNCUURUb54Cg4psAw=s0-d-e1-ft#https://id-mail-assets.atlassian.com/shared/logo/adg3/product/trello/logo-blue-new-2x.png\" height=\"30\" alt=\"Trello\" style=\"line-height:100%;outline:none;text-decoration:none;border:0\" class=\"CToWUd\" data-bit=\"iit\"></a></div><hr style=\"margin-top:24px;margin-bottom:24px;border:0;border-bottom:1px solid #c1c7d0\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse\"><tbody><tr><td align=\"center\"><img src=\"https://ci3.googleusercontent.com/meips/ADKq_NaqyeiZg4Sw8tgRdwrTcmENLIiDWsw_tWVsOlHzHUevTnGapAKy_3_SrQcBxSiqjZ4Y0IEr2qetYwWaDNIL6ubLCDnBKhLBSwbuWP8eO0xwZLhNilhwS_UFcXxqsK0e8stPVvCSR2F9IFNqfEIXBoR-_uNSlVMq1_HF6TYA=s0-d-e1-ft#https://id-mail-assets.atlassian.com/template/aid_signup_welcome_verify_cobranded_adg/trello-people.png\" height=\"175\" border=\"0\" alt=\"\" style=\"border:0;line-height:100%;outline:none;text-decoration:none\" class=\"CToWUd a6T\" data-bit=\"iit\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 377.047px; top: 270px;\"><div id=\":198\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" role=\"button\" tabindex=\"0\" aria-label=\"첨부파일() 다운로드\" jslog=\"91252; u014N:cOuCgd,Kr2w4b,xr6bB; 4:WyIjbXNnLWY6MTc3ODc5MTU1MTM4Nzk0MjMwOCJd\" data-tooltip-class=\"a1V\" jsaction=\"JIbuQc:.CLIENT\" data-tooltip=\"다운로드\"><div class=\"akn\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div></div></td></tr></tbody></table><h1 style=\"margin-bottom:0;font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Fira Sans,Droid Sans,Helvetica Neue,sans-serif;font-size:24px;font-weight:500;letter-spacing:-0.01em;color:#172b4d;line-height:28px;margin-top:40px\">You’re nearly there!</h1><p style=\"font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Fira Sans,Droid Sans,Helvetica Neue,sans-serif;font-size:14px;font-weight:400;letter-spacing:-0.005em;color:#091e42;line-height:20px;margin-top:12px\"><a style=\"text-decoration:none;color:inherit\">Hi " +
                    username +
                    ",</a></p><p style=\"font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Fira Sans,Droid Sans,Helvetica Neue,sans-serif;font-size:14px;font-weight:400;letter-spacing:-0.005em;color:#091e42;line-height:20px;margin-top:12px\">To <span class=\"il\">complete </span> sign up to our website please click the button below to continue sign up with <strong><a style=\"text-decoration:none;color:inherit\">" +
                    email +
                    "</a></strong>.</p><div style=\"margin-top:28px\"><a href=\"http://localhost:8091/signup?token=hiimtoken\" style=\"box-sizing:border-box;border-radius:3px;border-width:0;border:none;display:inline-flex;font-style:normal;font-size:inherit;line-height:24px;margin:0;outline:none;padding:4px 12px;text-align:center;vertical-align:middle;white-space:nowrap;text-decoration:none;background:#0052cc;color:#ffffff\" target=\"_blank\" data-saferedirecturl=\"http://localhost:8091/signup?token=hiimtoken\">Continue</a></div><hr style=\"margin-top:24px;margin-bottom:24px;border:0;border-bottom:1px solid #c1c7d0\"><p style=\"font-family:-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Fira Sans,Droid Sans,Helvetica Neue,sans-serif;font-size:14px;font-weight:400;letter-spacing:-0.005em;color:#091e42;line-height:20px;margin-top:12px\">For more info, visit the <a href=\"https://help.trello.com/article/1197-using-trello-with-an-atlassian-account\" style=\"border:none;background:transparent;color:#0052cc;text-decoration:none\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://help.trello.com/article/1197-using-trello-with-an-atlassian-account&amp;source=gmail&amp;ust=1702340657045000&amp;usg=AOvVaw1kFoQR3q7RPb1o-5qyJSgh\">help page</a>.</p><hr style=\"margin-top:24px;margin-bottom:24px;border:0;border-bottom:1px solid #c1c7d0\"><div style=\"color:#707070;font-size:13px;line-height:19px;text-align:center;margin-top:10px\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\" align=\"center\" style=\"padding-top:10px;line-height:18px;text-align:center; font-weight:normal; font-size:12px;color:#505f79\"><span>This message was sent to you by Atlassian Cloud</span><br></td></tr><tr valign=\"top\"><td align=\"center\" style=\"padding-top:15px;padding-bottom:30px\"><a href=\"https://www.atlassian.com\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.atlassian.com&amp;source=gmail&amp;ust=1702340657045000&amp;usg=AOvVaw0x2gi0wzxaAZZ5CwRukBp4\"><img src=\"https://ci3.googleusercontent.com/meips/ADKq_Na6XzjWLy087GFD9hbEVqXoklvXJNS90Id5N9MxbfEi4xqTyfVUuwJG-PPQvOSGaaoV_Hmp8_0sVuzpjjCAg-gS-OyuVLoCZvj9xOIyPeNjBlvbaMKaPJf9qjvRQErEmAZ9QNIYV4u4H0B49K_9zg=s0-d-e1-ft#https://id-mail-assets.atlassian.com/shared/id-summit/id-summit-email_logo_360x80_NEW.png\" width=\"114\" border=\"0\" alt=\"Atlassian\" style=\"border:0;line-height:100%;outline:none;text-decoration:none;display:block;color:#4c9ac9\" class=\"CToWUd\" data-bit=\"iit\"></a></td></tr></tbody></table></div></div></div></td></tr></tbody></table>\n" +
                    "        <img border=\"0\" width=\"1\" height=\"1\" alt=\"\" src=\"https://ci3.googleusercontent.com/meips/ADKq_Na58tj39rwv-Jt3h6_2cq2pebi0hqsYfurnmO4NXjR7Tvj_yz07oqIoOAMPUAyLfsbQmN4Lcfojb8Yqv0YYmCcDn7nTh8HjXUK5Qa4xEqs8bZBYqoj4_NERhg1BS6XxtSqivfzt5CXVpNrB5V-F-MaKDk0IzjRGUpNjDGfabemQhQisfV0ipR4D7lAOaAfgtXM0AboLR8F2J5x1FTNheOR9fdmlKK4nusl9oQQUGDs=s0-d-e1-ft#http://atlassian.et.e.sparkpost.com/q/hp6i1NpCjCVTBrIF6f96GA~~/AAAAAQA~/RgRm_1foPlcLYXRsYXNzaWFudXNCCmUU6NIcZdfVI5ZSEmNob2luYTQwQGdtYWlsLmNvbVgEAAAAAA~~\" class=\"CToWUd\" data-bit=\"iit\"><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                    "        </div></div></div></div>\n" +
                    "</body>\n" +
                    "</html>";

            helper.setTo(email);
            helper.setFrom(senderEmail);
            helper.setSubject("trello test");

            helper.setText(content, true);
        };
        javaMailSender.send(preparatory);
    }
}
