package com.example.trelloweb.user.signup.controller;

import com.example.trelloweb.user.signup.form.SignupForm;
import com.example.trelloweb.user.signup.service.UserSignupService;
import com.example.trelloweb.user.signup.vo.SignupVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    @GetMapping("/chkEmail")
    @ResponseBody
    public int chkEmail(@RequestParam("email") String email){
        return userSignupService.checkEmail(email);
    }
    @GetMapping("/idcheck")
    @ResponseBody
    public int checkDuplicateSignup(@RequestParam("id") String id){
        return userSignupService.idDuplicateCheck(id);
    }

    @GetMapping("/nickcheck")
    @ResponseBody
    public int nickcheck(@RequestParam("nick") String nick){
        return userSignupService.nicknameCheck(nick);
    }

    @GetMapping("/phonecheck")
    @ResponseBody
    public int phonecheck(@RequestParam("phone") String phone){
        return userSignupService.phoneCheck(phone);
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
        view.addObject("signupForm", signupForm);
        view.setViewName("/views/signup/signUp");
        if(bindingResult.hasErrors()){
            return view;
        }

        if(!signupForm.getPw().equals(signupForm.getPwcheck())){
            bindingResult.rejectValue("pwcheck", "passwordInCorrect","비밀번호 확인을 다시 입력해주세요");
            return view;
        }
        try {
            userSignupService.creat(signupForm.getId(), signupForm.getPw(),signupForm.getNickname(), signupForm.getName(), signupForm.getEMAIL(),signupForm.getBIRTH(), "M",
                    signupForm.getPhone(),signupForm.getBIO());
        }catch (DataIntegrityViolationException e){
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return view;
        }catch (Exception e){
            bindingResult.reject("signupFailed", e.getMessage());
            return view;
        }
        view.setViewName("redirect:/");
        return view;
    }
}
