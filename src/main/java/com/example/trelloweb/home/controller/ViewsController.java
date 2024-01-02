package com.example.trelloweb.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/views")
public class ViewsController {
    @RequestMapping("")
    public ModelAndView views() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutViews");
        return view;
    }
    @RequestMapping("/calendar")
    public ModelAndView calendar() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutCalendar");
        return view;
    }
    @RequestMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutDashboard");
        return view;
    }

    @RequestMapping("/map")
    public ModelAndView map() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutMap");
        return view;
    }

    @RequestMapping("/table")
    public ModelAndView table() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutTable");
        return view;
    }

    @RequestMapping("/timeline")
    public ModelAndView timeline() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutTimeline");
        return view;
    }

    @RequestMapping("/workspace")
    public ModelAndView workspace() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/about/aboutWorkspace");
        return view;
    }
}
