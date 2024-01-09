package com.example.trelloweb.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Denied {
    @GetMapping("/denied")
    public ModelAndView getDenied(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/denied/denied");
        return view;
    }
}
