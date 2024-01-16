//package com.example.trelloweb.user.oauthSign.service;
//
//import com.example.trelloweb.user.oauthSign.attribute.OAuthAttribute;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);
//        String registation = userRequest.getClientRegistration().getRegistrationId();
//        String usernameAttribute = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
//
//        OAuthAttribute attribute = OAuthAttribute.of(registation, usernameAttribute, oAuth2User.getAttributes());
//        System.out.println(registation);
//        System.out.println(usernameAttribute);
//        System.out.println(attribute.getAttributes());
//        return oAuth2User;
//
//    }
//}
