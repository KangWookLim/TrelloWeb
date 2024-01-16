package com.example.trelloweb.boarddetail.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BoardDetailController {
    @RequestMapping("/board_detail")
    public ModelAndView detail(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/views/board/board_detail");
        return view;
    }
}
