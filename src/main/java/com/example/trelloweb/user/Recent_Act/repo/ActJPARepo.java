package com.example.trelloweb.user.Recent_Act.repo;

import com.example.trelloweb.user.Recent_Act.vo.RecentActVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActJPARepo extends JpaRepository<RecentActVo,Long> {
}
