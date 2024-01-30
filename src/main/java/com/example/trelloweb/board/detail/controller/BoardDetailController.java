package com.example.trelloweb.board.detail.controller;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.board.board_mem.entity.Board_memPk;
import com.example.trelloweb.board.detail.service.BoardDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardDetailController {
    private final BoardDetailService boardDetailService;

    @GetMapping("/{boardId}")
    public ModelAndView detail(@PathVariable("boardId") String boardId, Principal principal){
        ModelAndView view = new ModelAndView();
        BoardVo boardvo = boardDetailService.findBoardById(boardId);
        Board_memPk board_memPk = new Board_memPk(principal.getName(), Long.valueOf(boardId));
        if(boardDetailService.existsById(board_memPk)){
            view.addObject("board",boardvo);
            view.setViewName("/views/board/board_detail");
        }else{
            throw new IllegalStateException("잘못된 접근입니다");
        }
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