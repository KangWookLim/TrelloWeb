package com.example.trelloweb.user.base.repo;

import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.base.vo.UserinfoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserinfoRepo extends JpaRepository<UserVo, String> {

    Optional<UserinfoVo> findByUseruid(@Param("useruid") String useruid);
}
