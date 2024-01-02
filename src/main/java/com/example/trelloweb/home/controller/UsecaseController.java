package com.example.trelloweb.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usecase")
public class UsecaseController {
    @RequestMapping("")
    public ModelAndView usecase() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/useCases");
        return view;
    }

    @RequestMapping("/projectmanagement")
    public ModelAndView projectManagement() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutProjectManagement");
        return view;
    }
}
