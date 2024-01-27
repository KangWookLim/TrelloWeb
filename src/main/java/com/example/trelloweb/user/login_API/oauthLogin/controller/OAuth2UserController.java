package com.example.trelloweb.user.login_API.oauthLogin.controller;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.login_API.loginVo.AuthUser;
import com.example.trelloweb.user.login_API.oauthLogin.form.ThirdSignForm;
import com.example.trelloweb.user.login_API.service.UserLoginService;
import com.example.trelloweb.user.signup.service.UserSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class OAuth2UserController {

    private final UserJpaRepo userJpaRepo;


    @GetMapping("/OAuth2UserCheck")
    public ModelAndView OAuth2User(ThirdSignForm thirdSignForm, OAuth2AuthenticationToken authenticationToken){
        ModelAndView view = new ModelAndView();
        String UserUID = authenticationToken.getPrincipal().getName();
        System.out.println(authenticationToken.getPrincipal());
        if(userJpaRepo.existsByUseruid(UserUID)){
            view.setViewName("redirect:/home");
        }else{
            view.setViewName("views/oauth2/oauth2sign");
        }
        return view;
    }
}
