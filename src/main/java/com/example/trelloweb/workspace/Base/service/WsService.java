package com.example.trelloweb.workspace.Base.service;

import com.example.trelloweb.workspace.Base.Repo.WsJPARepo;
import com.example.trelloweb.workspace.Base.vo.WorkSpaceVo;
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
}
