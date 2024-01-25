package com.example.trelloweb.user.signup.controller;

import com.example.trelloweb.user.signup.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class SignupRestController {

    private final UserSignupService userSignupService;

    @GetMapping("/chkID")
    @ResponseBody
    public int IDcheck(@RequestParam("id") String id){ return userSignupService.IDduplicateCheck(id); }

    @GetMapping("/chkEmail")
    @ResponseBody
    public int chkEmail(@RequestParam("email") String email) {
        return userSignupService.checkEmail(email);
    }

    @GetMapping("/nickcheck")
    @ResponseBody
    public int nickcheck(@RequestParam("nick") String nick) {
        return userSignupService.nicknameCheck(nick);
    }

}
