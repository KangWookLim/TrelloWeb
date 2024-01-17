package com.example.trelloweb.user.oauthLogin.controller;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.oauthLogin.form.ThirdSignForm;
import com.example.trelloweb.user.signup.service.UserSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class OAuth2UserController {

    private final UserJpaRepo userJpaRepo;
    private final UserSignupService userSignupService;

    @GetMapping("/OAuth2UserCheck")
    public ModelAndView OAuth2User(ThirdSignForm thirdSignForm, OAuth2AuthenticationToken authenticationToken){
        ModelAndView view = new ModelAndView();
        String authEmail = authenticationToken.getPrincipal().getAttribute("email");
        if(userJpaRepo.existsByEMAIL(authEmail)){
            view.setViewName("redirect:/home");
        }else{
            view.setViewName("views/oauth2/oauth2sign");
        }
        return view;
    }
    @PostMapping("/OAuth2UserCheck")
    public ModelAndView OAuth2User(@Valid ThirdSignForm thirdSignForm, BindingResult bindingResult, OAuth2AuthenticationToken authenticationToken){
        Map<String,Object> authuser = authenticationToken.getPrincipal().getAttributes();
        ModelAndView view = new ModelAndView();
        view.addObject("thirdSignForm", thirdSignForm);
        view.setViewName("views/oauth2/oauth2sign");
        System.out.println(authenticationToken.getPrincipal().getAttributes());
        if(bindingResult.hasErrors()){
            return view;
        }
        if(!thirdSignForm.getPW().equals(thirdSignForm.getPWCK())){
            bindingResult.rejectValue("PWCK", "passwordInCorrect","비밀번호 확인을 다시 입력해주세요");
            return view;
        }
        try {
            userSignupService.creat((String) authuser.get("email"),thirdSignForm.getPW(),thirdSignForm.getNickname(),(String) authuser.get("name"),thirdSignForm.getBirth(),null);
        }catch (DataIntegrityViolationException e){
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다");
            return view;
        }catch (Exception e){
            bindingResult.reject("signupFailed", "알 수 없는 오류입니다");
            return view;
        }
        view.setViewName("redirect:/home");
        return view;
    }
}
