package com.example.trelloweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView mainPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/home");
        return view;
    }
    //이동 예정
    @RequestMapping("/editprofile")
    public ModelAndView editProfile() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/profile/editProfile");
        return view;
    }
}

