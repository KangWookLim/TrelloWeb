package com.example.trelloweb.workspace.wsmem.service;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.board.board_mem.repo.BoardMemJpaRepo;
import com.example.trelloweb.board.board_mem.vo.Board_memVo;
import com.example.trelloweb.user.base.vo.UserVo;
import com.example.trelloweb.workspace.Base.Repo.WsJPARepo;
import com.example.trelloweb.workspace.Base.vo.WorkSpaceVo;
import com.example.trelloweb.workspace.wsmem.Repo.WsMemJpaRepo;
import com.example.trelloweb.workspace.wsmem.vo.WorkSpaceMemVo;
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
