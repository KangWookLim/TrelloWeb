package com.example.trelloweb.boarddetail.controller;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.boarddetail.service.BoardDetailService;
import com.example.trelloweb.card.base.vo.CardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/card_detail")
    @ResponseBody
    public CardVo getCardDetail(@RequestParam("cardid") Long cardid){
        Optional<CardVo> optCardVo = boardDetailService.getCardDetail(cardid);
        return optCardVo.orElse(null);
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