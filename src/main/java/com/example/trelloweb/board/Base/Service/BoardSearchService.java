package com.example.trelloweb.board.Base.Service;

import com.example.trelloweb.board.Base.repo.BoardJpaRepo;
import com.example.trelloweb.board.Base.repo.BoardRepo;
import com.example.trelloweb.board.Base.vo.Boards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardSearchService{
    private final BoardRepo boardRepo;
    private final BoardJpaRepo BoardJpaRepo;

    public List<Boards> loadBoardByUsername(String mem_id) { return boardRepo.getAllBoardInfo(mem_id);}
}
