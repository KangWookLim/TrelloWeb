package com.example.trelloweb.workspace.Base.Repo;

import com.example.trelloweb.workspace.Base.entity.WorkSpaceVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WsJPARepo extends JpaRepository<WorkSpaceVo, Long> {
}
