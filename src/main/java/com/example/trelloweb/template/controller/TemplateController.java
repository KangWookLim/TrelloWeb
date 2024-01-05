package com.example.trelloweb.template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TemplateController {

    @GetMapping("/template")
    public ModelAndView board() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/template/template");
        return view;
    }

    @GetMapping("/template/business")
    public ModelAndView business() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/template/business");
        return view;
    }

}
