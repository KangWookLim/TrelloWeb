package com.example.trelloweb.login.controller;

import com.example.trelloweb.login.service.LoginService;
import com.example.trelloweb.login.vo.GoogleInfResponse;
import com.example.trelloweb.login.vo.GoogleRequest;
import com.example.trelloweb.login.vo.GoogleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@CrossOrigin("*")
//@Controller
//public class LoginController {
//
//    @GetMapping("/login")
//    public ModelAndView loginPage() {
//        ModelAndView view = new ModelAndView();
//        view.setViewName("views/login");
//        return view;
//    }
//
//
//}

@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class LoginController {

    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/code/{registrationId}")
    public void googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        loginService.socialLogin(code, registrationId);
    }
}