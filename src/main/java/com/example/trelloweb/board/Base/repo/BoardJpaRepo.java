package com.example.trelloweb.board.Base.repo;

import com.example.trelloweb.board.Base.vo.Boards;
import com.example.trelloweb.user.base.vo.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardJpaRepo extends JpaRepository<UserVo,Long> {
    Optional<Boards> findByID(String id);
}

