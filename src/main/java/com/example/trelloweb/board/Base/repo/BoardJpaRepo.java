package com.example.trelloweb.board.Base.repo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepo extends JpaRepository<BoardVo,Long> {
}