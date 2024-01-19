package com.example.trelloweb.boarddetail.service;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.boarddetail.repo.BoardDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardDetailService {
    private final BoardDetailRepo boardDetailRepo;
    public List<BoardVo> getAllBoard() {

        return boardDetailRepo.findAll();
    }

    /*public List<BoardVo> getBoardById(Long boardId) {
        return boardDetailRepo.findAllByBoardId(boardId);
    }*/

    /*public List<BoardVo> getAllByBoardId(Long boardID) {
        return boardDetailRepo.findallByBoardId(boardID);
    }*/
}
