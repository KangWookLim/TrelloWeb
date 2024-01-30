package com.example.trelloweb.board.detail.controller;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.board.board_mem.entity.Board_memPk;
import com.example.trelloweb.board.detail.service.BoardDetailService;
import com.example.trelloweb.user.Recent_Act.service.ActService;
import jakarta.servlet.http.HttpServletRequest;
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
    private final ActService actService;

    @GetMapping("/{boardId}")
    public ModelAndView detail(@PathVariable("boardId") String boardId, Principal principal, HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        String currentUrl = request.getRequestURI();
        BoardVo boardvo = boardDetailService.findBoardById(boardId);
        Board_memPk board_memPk = new Board_memPk(principal.getName(), Long.valueOf(boardId));
        if(boardDetailService.existsById(board_memPk)){
            actService.addRecentAct(principal.getName(),currentUrl);
            view.addObject("board",boardvo);
            view.setViewName("/views/board/board_detail");
        }else{
            view.setViewName("redirect:/board");
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