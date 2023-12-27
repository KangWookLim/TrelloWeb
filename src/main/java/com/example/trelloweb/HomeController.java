package com.example.trelloweb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/automation")
    public ModelAndView dashboard() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutAutomation");
        return view;
    }
}
