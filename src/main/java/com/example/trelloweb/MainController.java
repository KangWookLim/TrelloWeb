package com.example.trelloweb;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView mainPage(HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("test/test");
        return view;
    }
    //이동 예정
    @RequestMapping("/editprofile")
    public ModelAndView editProfile() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/profile/editProfile");
        return view;
    }

    @RequestMapping("/profile")
    public ModelAndView profile() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/profile/profile");
        return view;
    }
}

