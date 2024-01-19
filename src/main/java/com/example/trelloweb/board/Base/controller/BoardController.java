package com.example.trelloweb.board.Base.controller;

import com.example.trelloweb.board.Base.service.BoardSearchService;
import com.example.trelloweb.board.Base.vo.Boards;
import com.example.trelloweb.board.Base.vo.WorkSpaces;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardSearchService boardSearchService;

    @GetMapping("/board")//User's current board
    @ResponseBody
    public ModelAndView board(Principal principal) {
        ModelAndView view = new ModelAndView();
        List<Boards> boardsList = boardSearchService.findAllboards(principal.getName());
        List<WorkSpaces> WSList = boardSearchService.findAllWS(principal.getName());
        view.addObject("WSList", WSList);
        view.addObject("boardsList", boardsList);
        view.setViewName("views/board/board");
        return view;
    }

    @GetMapping("/home")//Authuser's home page
    public ModelAndView home(Principal principal) {
        ModelAndView view = new ModelAndView();
        System.out.println(principal    );
        List<WorkSpaces> WSList = boardSearchService.findAllWS(principal.getName());
        view.addObject("WSList", WSList);
        view.setViewName("views/board/home");
        return view;
    }

}
