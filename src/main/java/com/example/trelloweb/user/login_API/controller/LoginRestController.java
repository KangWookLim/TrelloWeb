package com.example.trelloweb.user.login_API.controller;

import com.example.trelloweb.user.base.service.UserService;
import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginRestController {
}
