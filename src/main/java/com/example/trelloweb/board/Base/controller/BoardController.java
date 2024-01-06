package com.example.trelloweb.board.Base.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/board")
    public ModelAndView board() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/board/board");
        return view;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/board/home");
        return view;
    }

}
