package com.example.trelloweb.config;

import com.example.trelloweb.user.Role.UserRole;
import com.example.trelloweb.user.oauthLogin.service.CustomOAuth2UserService;
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


    private final CustomOAuth2UserService customOAuth2UserService;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/user/login"),new AntPathRequestMatcher("/user/signup"),new AntPathRequestMatcher("/user/startSign")).anonymous()
                        .requestMatchers(new AntPathRequestMatcher("/user/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/home/**"), new AntPathRequestMatcher("/board/**"), new AntPathRequestMatcher("/template/**")).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/admin")).hasRole(UserRole.ADMIN.getValue())
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/denied"))
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/h2/**")))
                .headers(headers -> headers
                        .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                .formLogin(formLogin -> formLogin
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/home"))
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/user/login")
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                                .userService(customOAuth2UserService))
                        .defaultSuccessUrl("/user/OAuth2UserCheck"))
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true));
        return http.getOrBuild();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
