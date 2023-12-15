package com.example.trelloweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView mainPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/home");
        return view;
    }
    @GetMapping ("/startSign")
    public ModelAndView startSignPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/startSign");
        return view;
    }

    @GetMapping ("/login")
    public ModelAndView loginPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/login");
        return view;
    }
    @GetMapping ("/emailSent")
    public ModelAndView emailSent() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/emailSent");
        return view;
    }

    @GetMapping ("/test")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/useCases");
        return view;
    }

}

