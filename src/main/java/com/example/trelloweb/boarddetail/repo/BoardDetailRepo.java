package com.example.trelloweb.boarddetail.repo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.card.base.vo.CardVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDetailRepo extends JpaRepository<BoardVo,Long> {

    /*List<BoardVo> findAllByBoardId(Long boardId);*/



    /*List<BoardVo> findallByBoardId(Long );*/
}