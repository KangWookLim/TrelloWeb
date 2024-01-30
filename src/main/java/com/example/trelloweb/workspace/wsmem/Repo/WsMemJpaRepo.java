package com.example.trelloweb.workspace.wsmem.Repo;

import com.example.trelloweb.workspace.wsmem.entity.WorkSpaceMemVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WsMemJpaRepo extends JpaRepository<WorkSpaceMemVo, Long> {
}
