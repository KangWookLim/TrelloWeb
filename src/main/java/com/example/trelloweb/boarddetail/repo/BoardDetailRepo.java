package com.example.trelloweb.boarddetail.repo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.card.base.vo.CardVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface BoardDetailRepo extends JpaRepository<BoardVo,Long> {

    /*List<BoardVo> findAllByBoardId(Long boardId);*/



    /*List<BoardVo> findallByBoardId(Long );*/
    Optional<BoardVo> findBoardVoByBoardName(String boardName);
}