package com.example.trelloweb.workspace.wsmem.service;

import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.workspace.Base.entity.WorkSpaceVo;
import com.example.trelloweb.workspace.wsmem.Repo.WsMemJpaRepo;
import com.example.trelloweb.workspace.wsmem.entity.WorkSpaceMemVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WsMemService {
    private final WsMemJpaRepo wsMemJpaRepo;

    public void create(WorkSpaceVo WsVo, UserVo userVo) {
        WorkSpaceMemVo WsMemVo = new WorkSpaceMemVo();
        WsMemVo.setUservo(userVo);
        WsMemVo.setWSID(WsVo);
        WsMemVo.setRole("Nomal");
        wsMemJpaRepo.save(WsMemVo);
    }
}
