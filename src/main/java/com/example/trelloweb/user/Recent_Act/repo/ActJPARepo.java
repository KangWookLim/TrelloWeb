package com.example.trelloweb.user.Recent_Act.repo;

import com.example.trelloweb.user.Recent_Act.entity.RecentActVo;
import com.example.trelloweb.user.base.entity.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ActJPARepo extends JpaRepository<RecentActVo,Long> {
    @Query("select (count(u) > 0) from User_Recent_Act u where u.actUri = :actUri and u.uservo = :userVo")
    boolean existsByActUriAndUservo(@Param("actUri") String actUri, @Param("userVo") UserVo userVo);
    RecentActVo findByActUriAndUservo(String actUri, UserVo userVo);
}
