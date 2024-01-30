package com.example.trelloweb.user.base.repo;

import com.example.trelloweb.user.base.entity.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepo extends JpaRepository<UserVo, String> {

    Optional<UserVo> findByUseruid(String useruid);
    boolean existsByUseruid(String userUID);
    Optional<UserVo> findByID(String id);
    Optional<UserVo> findByEMAIL(String email);
    boolean existsByEMAIL(String email);


}
