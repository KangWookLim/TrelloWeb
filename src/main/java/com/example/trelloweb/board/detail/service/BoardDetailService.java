package com.example.trelloweb.board.detail.service;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.board.Base.repo.BoardJpaRepo;
import com.example.trelloweb.board.board_mem.entity.Board_memPk;
import com.example.trelloweb.board.board_mem.repo.BoardMemJpaRepo;
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
    private final BoardMemJpaRepo boardMemJpaRepo;
    private final CardDetailJPARepo cardDetailJPARepo;
    private final CardDetailRepo cardDetailRepo;
    private final CardMemberRepo cardMemberRepo;
    public List<BoardVo> getAllBoard() {
        return boardJpaRepo.findAll();
    }
    public BoardVo findBoardById(String id) {
        return boardJpaRepo.findById(Long.parseLong(id)).orElse(null);
    }

    public boolean existsById(Board_memPk board_memPk){
        return boardMemJpaRepo.existsById(board_memPk);
    }


}

/*public List<BoardVo> getBoardById(Long boardId) {
        return boardDetailRepo.findAllByBoardId(boardId);
    }*/

    /*public List<BoardVo> getAllByBoardId(Long boardID) {
        return boardDetailRepo.findallByBoardId(boardID);
    }*/