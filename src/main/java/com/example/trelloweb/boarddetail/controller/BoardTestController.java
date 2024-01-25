package com.example.trelloweb.boarddetail.controller;

import com.example.trelloweb.boarddetail.service.BoardDetailService;
import com.example.trelloweb.user.Recent_Act.service.ActService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardTestController {
    private final BoardDetailService boardDetailService;
    private final ActService actService;

    @RequestMapping("/{boardName}")
    public void boardDetail(@PathVariable String boardName, Principal principal) {
        ModelAndView view = new ModelAndView();

    }
}
