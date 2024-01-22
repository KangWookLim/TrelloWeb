package com.example.trelloweb.user.login_API.oauthLogin.service;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.vo.UserVo;
import com.example.trelloweb.user.login_API.loginVo.AuthUser;
import com.example.trelloweb.user.login_API.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserJpaRepo userJpaRepo;
    private final UserLoginService userLoginService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest){
        String provider = userRequest.getClientRegistration().getRegistrationId();
        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);
        System.out.println(oAuth2User);
        if(provider.equals("google")){
            String Email = oAuth2User.getAttribute("email");
            System.out.println(Email);
            if(userJpaRepo.existsByEMAIL(Email)){
                AuthUser authUser = userLoginService.loadUserByUsername(Email);
                authUser.setAuthProvider(provider);
                return authUser;
            }
        }else if(provider.equals("naver")) {
            String Email = oAuth2User.getAttribute("email");
            System.out.println(((Map<String, Objects>)oAuth2User.getAttribute("response")).get("email"));
            if(userJpaRepo.existsByEMAIL(Email)){
                AuthUser authUser = userLoginService.loadUserByUsername(Email);
                authUser.setAuthProvider(provider);
                return authUser;
            }
        }
        return oAuth2User;
    }
}
