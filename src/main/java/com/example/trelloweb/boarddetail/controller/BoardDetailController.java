package com.example.trelloweb.boarddetail.controller;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.boarddetail.service.BoardDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardDetailController {
    private final BoardDetailService boardDetailService;
    @RequestMapping("/board_detail")
    public ModelAndView detail(){
        ModelAndView view = new ModelAndView();
        List<BoardVo> boards = boardDetailService.getAllBoard();
        view.addObject("boards",boards);
        view.setViewName("/views/board/board_detail");
        return view;
    }



}

/*@RequestMapping("/board_detail/{board_id}")
    public ModelAndView detailById(@PathVariable("board_id") Long board_id){
        ModelAndView view = new ModelAndView();
        List<BoardVo> boards = boardDetailService.getBoardById(board_id);
        view.addObject("boards",boards);
        view.setViewName("/views/board/board_detail");
        return view;
    }*/