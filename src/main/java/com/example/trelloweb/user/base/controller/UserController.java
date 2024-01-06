package com.example.trelloweb.user.base.controller;

import com.example.trelloweb.user.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/user/chkEmail")
    @ResponseBody
    public int checkEmail(@RequestParam(name="Email") String email) throws Exception {
        System.out.println(email);
        return userService.checkEmail(email);
    }

    /*@RequestMapping("/user/getInfo")
    @ResponseBody
    public int getInfoById(@RequestParam(name = "userUID") String userUID) throws Exception {
        System.out.println()

    }*/

}
