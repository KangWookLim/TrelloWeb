package com.example.trelloweb.user.Recent_Act.service;


import com.example.trelloweb.user.Recent_Act.repo.ActJPARepo;
import com.example.trelloweb.user.Recent_Act.entity.RecentActVo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ActService {
    private final ActJPARepo actJPRepo;
    private final UserService userService;

    public void create(String useruid, String uri){
        RecentActVo recentActVo = new RecentActVo();
        recentActVo.setUservo(userService.findByUSER_UID(useruid).orElse(null));
        recentActVo.setActUri(uri);
        actJPRepo.save(recentActVo);
    }

    public void addRecentAct(String useruid, String actUri){
        UserVo user = userService.findByUSER_UID(useruid).orElse(null);
        if(actJPRepo.existsByActUriAndUservo(actUri,user)){
            RecentActVo recentAct = actJPRepo.findByActUriAndUservo(actUri,user);
            recentAct.setActDate(LocalDateTime.now());
            actJPRepo.save(recentAct);
        }else{
            RecentActVo recentAct = new RecentActVo();
            recentAct.setActUri(actUri);
            recentAct.setUservo(user);
            actJPRepo.save(recentAct);
        }
    }
}
