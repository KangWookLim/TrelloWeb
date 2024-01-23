package com.example.trelloweb.user.login_API.oauthLogin.controller;

import com.example.trelloweb.user.login_API.loginVo.AuthUser;
import com.example.trelloweb.user.login_API.oauthLogin.form.ThirdSignForm;
import com.example.trelloweb.user.signup.service.UserSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class OAuth2UserRestController {

    private final UserSignupService userSignupService;

    @PostMapping("/OAuth2UserCheck")
    public ModelAndView OAuth2User(@Valid ThirdSignForm thirdSignForm, BindingResult bindingResult, OAuth2AuthenticationToken authenticationToken){
        AuthUser authUser = (AuthUser) authenticationToken.getPrincipal();
        String id = authUser.getName();
        String picture = null;
        String email = null;
        String name = null;
        if(authUser.getAuthProvider().equals("google")){
            picture = (String)  authUser.getAttribute("picture");
            email = (String) authUser.getAttribute("email");
            name = (String)authUser.getAttribute("name");
        }else if(authUser.getAuthProvider().equals("naver")){
            picture = (String)authUser.getAttribute("picture");
            email = (String) authUser.getAttribute("email");
            name = (String)authUser.getAttribute("name");
        }else if(authUser.getAuthProvider().equals("github")){
            picture = (String)authUser.getAttribute("picture");
            email = (String) authUser.getAttribute("login");
            name = (String)authUser.getAttribute("name");
        }

        ModelAndView view = new ModelAndView();
        view.addObject("thirdSignForm", thirdSignForm);
        view.setViewName("views/oauth2/oauth2sign");
        SecurityContextHolder.getContext().setAuthentication(null);
        if(bindingResult.hasErrors()){
            return view;
        }
        if(!thirdSignForm.getPW().equals(thirdSignForm.getPWCK())){
            bindingResult.rejectValue("PWCK", "passwordInCorrect","비밀번호 확인을 다시 입력해주세요");
            return view;
        }
        try {
            userSignupService.OAuth2create(id ,thirdSignForm.getID() ,thirdSignForm.getPW(), email, thirdSignForm.getNickname(),name,
                    thirdSignForm.getBirth(),null,picture);
        }catch (DataIntegrityViolationException e){
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다");
            return view;
        }catch (Exception e){
            bindingResult.reject("signupFailed", "알 수 없는 오류입니다");
            return view;
        }
        view.setViewName("redirect:/user/login");
        return view;
    }
}
