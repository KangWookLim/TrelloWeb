package com.example.trelloweb.boarddetail.service;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.boarddetail.repo.BoardDetailRepo;
import com.example.trelloweb.card.base.vo.CardVo;
import com.example.trelloweb.card.repo.CardDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardDetailService {
    private final BoardDetailRepo boardDetailRepo;
    private final CardDetailRepo cardDetailRepo;
    public List<BoardVo> getAllBoard() {

        return boardDetailRepo.findAll();
    }


    public Optional<CardVo> getCardDetail(Long cardid) {

        return cardDetailRepo.findById(cardid);

    }
}

/*public List<BoardVo> getBoardById(Long boardId) {
        return boardDetailRepo.findAllByBoardId(boardId);
    }*/

    /*public List<BoardVo> getAllByBoardId(Long boardID) {
        return boardDetailRepo.findallByBoardId(boardID);
    }*/