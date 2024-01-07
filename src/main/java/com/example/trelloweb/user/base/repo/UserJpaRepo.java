package com.example.trelloweb.user.base.repo;

import com.example.trelloweb.user.base.vo.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<UserVo,Long> {
    Optional<UserVo> findByID(String id);
}
