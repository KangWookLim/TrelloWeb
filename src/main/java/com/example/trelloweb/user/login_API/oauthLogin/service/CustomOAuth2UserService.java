package com.example.trelloweb.user.login_API.oauthLogin.service;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.login_API.loginVo.AuthUser;
import com.example.trelloweb.user.login_API.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

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
        System.out.println(provider);
        System.out.println(oAuth2User);
        if(provider.equals("google")){
            String UID = oAuth2User.getName();
            Optional<UserVo> opUser = userJpaRepo.findByUseruid(UID);
            if(opUser.isPresent()){
                AuthUser authUser = userLoginService.loadUserByUsername(opUser.get().getID());
                authUser.setAuthProvider(provider);
                return authUser;
            }else {
                return AuthUser.builder()
                        .UID(UID)
                        .PW("1234")
                        .attributes(oAuth2User.getAttributes())
                        .AuthProvider("google")
                        .build();
            }
        }else if(provider.equals("naver")) {
            String UID = (String) ((Map<String,Object>)oAuth2User.getAttributes().get("response")).get("id");
            Optional<UserVo> opUser = userJpaRepo.findByUseruid(UID);
            if(opUser.isPresent()){
                AuthUser authUser = userLoginService.loadUserByUsername(opUser.get().getID());
                authUser.setAuthProvider(provider);
                return authUser;
            }else {
                return AuthUser.builder()
                        .UID(UID)
                        .PW("1234")
                        .attributes((Map<String,Object>)oAuth2User.getAttributes().get("response"))
                        .AuthProvider("naver")
                        .build();
            }
        }else if(provider.equals("github")) {
            String UID = oAuth2User.getName();
            Optional<UserVo> opUser = userJpaRepo.findByUseruid(UID);
            if(opUser.isPresent()){
                AuthUser authUser = userLoginService.loadUserByUsername(opUser.get().getID());
                authUser.setAuthProvider(provider);
                return authUser;
            }else {
                return AuthUser.builder()
                        .UID(UID)
                        .PW("1234")
                        .attributes(oAuth2User.getAttributes())
                        .AuthProvider("github")
                        .build();
            }
        }
        return null;
    }
}
