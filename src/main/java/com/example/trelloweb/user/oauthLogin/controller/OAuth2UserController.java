package com.example.trelloweb.user.oauthLogin.controller;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.oauthLogin.form.OAuth2SignForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class OAuth2UserController {

    private final UserJpaRepo userJpaRepo;

    @GetMapping("/OAuth2UserCheck")
    public ModelAndView OAuth2User(OAuth2AuthenticationToken authentication, OAuth2SignForm oAuth2SignForm){
        ModelAndView view = new ModelAndView();
        String authEmail = authentication.getPrincipal().getAttribute("email");
        if(userJpaRepo.existsByEMAIL(authEmail)){
            view.setViewName("redirect:/home");
        }else{
            view.setViewName("views/oauth2/oauth2sign");
        }
        return view;
    }
    @PostMapping("/OAuth2UserCheck")
    public ModelAndView OAuth2User(@Valid OAuth2SignForm oAuth2SignForm, BindingResult bindingResult){
        ModelAndView view = new ModelAndView();
        view.setViewName("views/oauth2/oauth2sign");
        return view;
    }
}
