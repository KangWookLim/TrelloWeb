package com.example.trelloweb.user.base.repo;

import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNullApi;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepo extends JpaRepository<UserVo, String> {

    Optional<UserVo> findByUseruid(String useruid);
    boolean existsByUseruid(String userUID);
    Optional<UserVo> findByID(String id);
    Optional<UserVo> findByEMAIL(String email);
    boolean existsByEMAIL(String email);

}
