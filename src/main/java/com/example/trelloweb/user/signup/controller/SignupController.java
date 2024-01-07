package com.example.trelloweb.user.signup.controller;

import com.example.trelloweb.user.signup.form.SignupForm;
import com.example.trelloweb.user.signup.service.UserSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class SignupController {
    private final UserSignupService userSignupService;

    @GetMapping("/startSign")
    public ModelAndView startSign(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/signup/startSign");
        return view;
    }
    @GetMapping("/signup")
    public ModelAndView signup(SignupForm signupForm){
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/signup/signUp");
        return view;
    }
    @PostMapping("/signup")
    public ModelAndView signup(@Valid SignupForm signupForm, BindingResult bindingResult) {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/signup/signUp");
        if(bindingResult.hasErrors()){
            return view;
        }

        if(!signupForm.getPw().equals(signupForm.getPwcheck())){
            bindingResult.rejectValue("pwcheck", "passwordInCorrect","비밀번호 확인을 다시 입력해주세요");
            return view;
        }
        try {
            userSignupService.creat(signupForm.getId(), signupForm.getPw(),signupForm. getIMG_URL() ,signupForm.getNickname(), signupForm.getFullname(), signupForm.getEMAIL(),signupForm.getBIRTH(), signupForm.getGENDER(),
                    signupForm.getPhone(),signupForm.getBIO(),signupForm.getSOCIAL_LINK_1(), signupForm.getSOCIAL_LINK_2(), signupForm.getSOCIAL_LINK_3(),signupForm.getSOCIAL_LINK_4());
        }catch (DataIntegrityViolationException e){
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
        }catch (Exception e){
            bindingResult.reject("signupFailed", e.getMessage());
            return view;
        }
        view.setViewName("redirect:/");
        return view;
    }
}
