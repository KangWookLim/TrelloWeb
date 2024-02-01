package com.example.trelloweb.board.detail.service;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.board.Base.repo.BoardJpaRepo;
import com.example.trelloweb.card.mem.repo.CardMemberRepo;
import com.example.trelloweb.card.base.repo.CardDetailJPARepo;
import com.example.trelloweb.card.base.repo.CardDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardDetailService {
    private final BoardJpaRepo boardJpaRepo;
    private final CardDetailJPARepo cardDetailJPARepo;
    private final CardDetailRepo cardDetailRepo;
    private final CardMemberRepo cardMemberRepo;
    public List<BoardVo> getAllBoard() {
        return boardJpaRepo.findAll();
    }
    public BoardVo findBoardById(String id) {
        return boardJpaRepo.findById(Long.parseLong(id)).orElse(null);
    }


}

/*public List<BoardVo> getBoardById(Long boardId) {
        return boardDetailRepo.findAllByBoardId(boardId);
    }*/

    /*public List<BoardVo> getAllByBoardId(Long boardID) {
        return boardDetailRepo.findallByBoardId(boardID);
    }*/