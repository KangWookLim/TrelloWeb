package com.example.trelloweb.boarddetail.service;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.boarddetail.repo.BoardDetailJPARepo;
import com.example.trelloweb.card.mem.repo.CardMemberRepo;
import com.example.trelloweb.card.base.vo.Cards;
import com.example.trelloweb.card.mem.vo.CardMembers;
import com.example.trelloweb.card.base.repo.CardDetailJPARepo;
import com.example.trelloweb.card.base.repo.CardDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardDetailService {
    private final BoardDetailJPARepo boardDetailRepo;
    private final CardDetailJPARepo cardDetailJPARepo;
    private final CardDetailRepo cardDetailRepo;
    private final CardMemberRepo cardMemberRepo;
    public List<BoardVo> getAllBoard() {
        return boardDetailRepo.findAll();
    }





}

/*public List<BoardVo> getBoardById(Long boardId) {
        return boardDetailRepo.findAllByBoardId(boardId);
    }*/

    /*public List<BoardVo> getAllByBoardId(Long boardID) {
        return boardDetailRepo.findallByBoardId(boardID);
    }*/