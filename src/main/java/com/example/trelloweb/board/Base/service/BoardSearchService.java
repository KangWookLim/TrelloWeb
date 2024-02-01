package com.example.trelloweb.board.Base.service;

import com.example.trelloweb.board.Base.repo.BoardRepo;
import com.example.trelloweb.board.Base.repo.StarredBoardRepo;
import com.example.trelloweb.board.Base.vo.Boards;
import com.example.trelloweb.board.Base.vo.StarredBoards;
import com.example.trelloweb.board.Base.vo.WorkSpaces;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardSearchService{
    private final BoardRepo boardrepo;
    private final StarredBoardRepo starredBoardRepo;

    public List<Boards> findAllboards(String memid) {
        return boardrepo.getAllBoardInfo(memid);
    }
    public List<WorkSpaces> findAllWS(String memid) {
        return boardrepo.getAllWSInfo(memid);
    }

    public List<StarredBoards> findAllStarredBoards(String memid) {
        return starredBoardRepo.getAllStarredBoardInfo(memid);
    }

}
