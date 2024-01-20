//package com.example.trelloweb.board.board_mem.service;
//
//import com.example.trelloweb.board.Base.vo.BoardVo;
//import com.example.trelloweb.board.board_mem.repo.BoardMemJpaRepo;
//import com.example.trelloweb.board.board_mem.vo.Board_memVo;
//import com.example.trelloweb.user.base.vo.UserVo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class BoardMemService {
//    private final BoardMemJpaRepo boardMemJpaRepo;
//
//    public Board_memVo create(BoardVo boardVo, UserVo userVo) {
//        Board_memVo boardMemVo = new Board_memVo();
//        boardMemVo.setUservo(userVo);
//        boardMemVo.setBoardvo(boardVo);
//        boardMemJpaRepo.save(boardMemVo);
//        return boardMemVo;
//    }
//
//}
