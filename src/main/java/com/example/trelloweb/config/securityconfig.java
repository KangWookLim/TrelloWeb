package com.example.trelloweb.config;

import com.example.trelloweb.user.login_API.oauthLogin.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class securityconfig {
    /*
        스프링 시큐리티를 활용해 유저의 로그인 세션 저장과 필요한 정보를 기존 httpsession에 담는 것보다 안전하게 전달합니다.
        시큐리티를 사용하며 완벽하게 이용하진 못했지만 동작 원리와 각 기능별 사용 타이밍 그리고 시큐리티가 어떻게 클라이언트의
        접속을 걸러내는지 그리고 그 방식을 어떻게 개발자 입맛에 맛게 구성하는지 공부하는 시간이 되었습니다.
    */

    /*
        By leveraging Spring Security, I ensure a more secure transmission of user login sessions and necessary information,
        compared to storing them in the existing HttpSession.
        While I haven't mastered the full capabilities of Spring Security,
        I've dedicated time to understanding its principles, the optimal timing for utilizing each feature,
        and how it effectively filters client connections.
        This learning process includes understanding how to configure Spring Security to suit developers' preferences.

        @Param customOAuth2UserService This parameter is used to retrieve the service that operates when a user successfully logs
        in through third-party authentication.
    */


    //  This class is configured Security and controls each mapping and access denied, mapping permission from authentication user's Roles.

    /*
        I may not be able to master Spring Security completely, but I have made efforts to leverage its features appropriately in different situations.
    */

    private final CustomOAuth2UserService customOAuth2UserService;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
        //encoding the User's password
    }
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/user/login"),new AntPathRequestMatcher("/user/signup"),
                                new AntPathRequestMatcher("/user/startSign"),
                                new AntPathRequestMatcher("/")).anonymous()
                        .requestMatchers(new AntPathRequestMatcher("/user/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/user/loginsetting")).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/home/**")
                                        ,new AntPathRequestMatcher("/board/**")
                                        ,new AntPathRequestMatcher("/template/**")).hasAnyRole("USER","ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/admin")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                        //This part is like anyRequestMatcher().permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/denied"))
                //Setting the access denied and exception Url
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/h2/**")))
                //If you attempt to connect to the H2-Console, you will encounter an error because you don't have the CSRF token.
                //This is the reason why this function was used
                .headers(headers -> headers
                        .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                //The X-Frame-Options header is used for security purposes in web applications, if our headers phishing from hackers or reject injection
                .formLogin(formLogin -> formLogin
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/home"))
                //Use the Login process in Spring Security in our customLoginpage and endpoint
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/user/login")
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                                .userService(customOAuth2UserService))
                        .defaultSuccessUrl("/user/OAuth2UserCheck"))
                //Third party Authentication like google and naver
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true))
                //purpose LogOut and clear the session
        ;

        return http.getOrBuild();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
        //Main Component for make User's Authentication and Role
    }
}
