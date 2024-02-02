package com.example.trelloweb.board.board_mem.service;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.board.board_mem.repo.BoardMemJpaRepo;
import com.example.trelloweb.board.board_mem.entity.Board_memVo;
import com.example.trelloweb.user.base.entity.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardMemService {
    private final BoardMemJpaRepo boardMemJpaRepo;

    public void create(BoardVo boardVo, UserVo userVo) {
        Board_memVo boardMemVo = new Board_memVo();
        boardMemVo.setUservo(userVo);
        boardMemVo.setBoardvo(boardVo);
        boardMemVo.setBoardaccess("Normal");
        boardMemJpaRepo.save(boardMemVo);
    }

}
