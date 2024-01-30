package com.example.trelloweb.boarddetail.repo;

import com.example.trelloweb.board.Base.entity.BoardVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDetailJPARepo extends JpaRepository<BoardVo,Long> {

    /*List<BoardVo> findAllByBoardId(Long boardId);*/



    /*List<BoardVo> findallByBoardId(Long );*/
}