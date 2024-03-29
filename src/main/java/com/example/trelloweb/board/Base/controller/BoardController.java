package com.example.trelloweb.board.Base.controller;

import com.example.trelloweb.board.Base.service.BoardSearchService;
import com.example.trelloweb.board.Base.service.BoardService;
import com.example.trelloweb.board.Base.vo.Boards;
import com.example.trelloweb.board.Base.vo.StarredBoards;
import com.example.trelloweb.board.Base.vo.WorkSpaces;
import com.example.trelloweb.board.board_mem.service.BoardMemService;
import com.example.trelloweb.user.base.service.UserService;
import com.example.trelloweb.workspace.Base.service.WsService;
import com.example.trelloweb.workspace.Base.entity.WorkSpaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardSearchService boardSearchService;
    private final BoardService boardService;
    private final BoardMemService boardMemService;
    private final WsService wsService;
    private final UserService userService;

    @GetMapping("/board")//User's current board
    @ResponseBody
    public ModelAndView board(Principal principal) {
        ModelAndView view = new ModelAndView();
        Set<Integer> isstarred = new HashSet<>();
        List<Boards> boardsList = boardSearchService.findAllboards(principal.getName());
        List<WorkSpaces> WSList = boardSearchService.findAllWS(principal.getName());
        List<StarredBoards> starredList = boardSearchService.findAllStarredBoards(principal.getName());
        for(Boards b : boardsList){
            for(StarredBoards s : starredList){
                if(b.getBOARD_ID()==s.getBOARD_ID()){
                    isstarred.add(b.getBOARD_ID());
                }
            }
        }
        view.addObject("starredList", starredList);
        view.addObject("WSList", WSList);
        view.addObject("isstarred",isstarred);
        view.addObject("boardsList", boardsList);
        view.setViewName("views/board/board");
        return view;
    }
    @PostMapping("/board/create")
    public ModelAndView createBoard(@RequestParam("BoardName") String BoardName, @RequestParam("WS_ID") int WS_ID, @RequestParam("ImgUrl") String ImgUrl, Principal principal) {
        ModelAndView view = new ModelAndView();
        WorkSpaceVo WS = wsService.getWsById((long)WS_ID);
        boardMemService.create(boardService.createBoard(BoardName,  ImgUrl, WS),userService.findByUSER_UID(principal.getName()).get());
        view.setViewName("redirect:/board");
        return view;
    }

    @PostMapping("/board/star")
    public ModelAndView updateStarBoard(@RequestParam(name="boardId") String boardId, Principal principal) {
        ModelAndView view = new ModelAndView();
        int check = boardService.checkStarredBoard(boardId, principal.getName());
        if(check > 0) {
            //delete starred board
            boardService.deleteStarredBoard(boardId, principal.getName());
        }else{
            //create starred board
            boardService.createStarredBoard(boardId, principal.getName());
        }
        view.setViewName("redirect:/board");
        return view;
    }
    @GetMapping("/home")//Authuser's home page
    public ModelAndView home(Principal principal) {
        ModelAndView view = new ModelAndView();
        System.out.println(principal);
        Set<Integer> isstarred = new HashSet<>();
        List<WorkSpaces> WSList = boardSearchService.findAllWS(principal.getName());
        List<Boards> boardsList = boardSearchService.findAllboards(principal.getName());
        List<StarredBoards> starredList = boardSearchService.findAllStarredBoards(principal.getName());
        for(Boards b : boardsList){
            for(StarredBoards s : starredList){
                if(b.getBOARD_ID()==s.getBOARD_ID()){
                    isstarred.add(b.getBOARD_ID());
                }
            }
        }
        view.addObject("starredList", starredList);
        view.addObject("isstarred",isstarred);
        view.addObject("WSList", WSList);
        view.setViewName("views/board/home");
        return view;
    }

}
