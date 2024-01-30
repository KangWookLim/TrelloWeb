package com.example.trelloweb.board.Base.service;

import com.example.trelloweb.board.Base.repo.BoardJpaRepo;
import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.board.Base.repo.StarredBoardRepo;
import com.example.trelloweb.workspace.Base.entity.WorkSpaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJpaRepo boardJpaRepo;
    private final StarredBoardRepo starredBoardRepo;

    public BoardVo createBoard(String boardTitle, String boardImg, WorkSpaceVo WS_ID) {
        BoardVo board = new BoardVo();
        board.setBoardName(boardTitle);
        board.setImageURL(boardImg);
        board.setWSID(WS_ID);
        return boardJpaRepo.save(board);
    }

    public int checkStarredBoard(String boardId, String memId) {
        return starredBoardRepo.checkStarredBoard(boardId, memId);
    }
}
