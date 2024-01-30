package com.example.trelloweb.board.board_mem.repo;

import com.example.trelloweb.board.board_mem.entity.Board_memPk;
import com.example.trelloweb.board.board_mem.entity.Board_memVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface BoardMemJpaRepo extends JpaRepository<Board_memVo, Board_memPk>{
//    boolean existsById(Board_memPk board_memPk);
}
