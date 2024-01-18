package com.example.trelloweb.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class Denied {
    @GetMapping("/denied")
    public ModelAndView getDenied(Principal principal){
        ModelAndView view = new ModelAndView();
        view.setViewName("/denied/denied");
        System.out.println(principal);
        return view;
    }
}
