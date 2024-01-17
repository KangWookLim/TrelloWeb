package com.example.trelloweb.boarddetail.controller;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.boarddetail.service.BoardDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        //List<BoardVo> boards = boardDetailService.getAllByBoardId(1L);
        view.addObject("boards",boards);

        view.setViewName("/views/board/board_detail");
        return view;
    }
}
