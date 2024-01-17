//package com.example.trelloweb.user.login_API.controller;
//
//import com.example.trelloweb.user.base.service.UserService;
//import com.example.trelloweb.user.base.vo.UserVo;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class LoginRestController {
//
//    private final UserService userService;
//
//    @RequestMapping("/loginsetting")
//    public String LoginSetting(HttpSession session, Principal principal){
//        Optional<UserVo> opUserVo = userService.findByUSER_UID(principal.getName());
//        if(opUserVo.isPresent()){
//            session.setAttribute("img",opUserVo.get().getIMG_URL());
//            session.setAttribute("email",);
//            return "redirect:/home";
//        }else{
//            return "redirect:/user/logout";
//        }
//    }
//}
