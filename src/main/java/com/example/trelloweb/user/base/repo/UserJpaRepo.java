package com.example.trelloweb.user.base.repo;

import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepo extends JpaRepository<UserVo, Long> {
    Optional<UserVo> findByEMAIL(String email);
}
