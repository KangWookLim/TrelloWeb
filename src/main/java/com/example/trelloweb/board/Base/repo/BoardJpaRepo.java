package com.example.trelloweb.board.Base.repo;

import com.example.trelloweb.board.Base.entity.BoardVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardJpaRepo extends JpaRepository<BoardVo,Long> {
}