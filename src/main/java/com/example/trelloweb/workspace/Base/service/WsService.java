package com.example.trelloweb.workspace.Base.service;

import com.example.trelloweb.workspace.Base.Repo.WsJPARepo;
import com.example.trelloweb.workspace.Base.entity.WorkSpaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WsService {
    private final WsJPARepo wsJPARepo;
    public WorkSpaceVo getWsById(Long id) {
       return wsJPARepo.findById(id).get();
    }
    public List<WorkSpaceVo> getAllWS(){
        return wsJPARepo.findAll();
    }

    public WorkSpaceVo createWS(String WsName, String WsImg) {
        WorkSpaceVo WS = new WorkSpaceVo();
        WS.setWorkspacename(WsName);
        WS.setIMG_URL(WsImg);
        return wsJPARepo.save(WS);
    }
}
