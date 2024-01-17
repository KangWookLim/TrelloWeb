package com.example.trelloweb.board.Base.service;

import com.example.trelloweb.board.Base.repo.BoardRepo;
import com.example.trelloweb.board.Base.vo.Boards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardSearchService{
    private final BoardRepo boardrepo;

    public List<Boards> findAllboards(String memid) {
        return boardrepo.getAllBoardInfo(memid);
    }
    public List<Boards> findAllWS(String memid) {
        return boardrepo.getAllWSInfo(memid);
    }


}
