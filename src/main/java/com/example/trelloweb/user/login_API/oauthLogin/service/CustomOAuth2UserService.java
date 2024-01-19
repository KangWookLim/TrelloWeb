package com.example.trelloweb.user.login_API.oauthLogin.service;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.vo.UserVo;
import com.example.trelloweb.user.login_API.loginVo.AuthUser;
import com.example.trelloweb.user.login_API.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{

    private final UserJpaRepo userJpaRepo;
    private final UserLoginService userLoginService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);
        String Email = (String) oAuth2User.getAttributes().get("email");
        if(userJpaRepo.existsByEMAIL(Email)){
            return userLoginService.loadUserByUsername(Email);
        }else {
            return oAuth2User;
        }
    }
}
