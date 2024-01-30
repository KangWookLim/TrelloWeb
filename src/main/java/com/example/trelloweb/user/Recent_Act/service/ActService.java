package com.example.trelloweb.user.Recent_Act.service;


import com.example.trelloweb.user.Recent_Act.repo.ActJPARepo;
import com.example.trelloweb.user.Recent_Act.vo.RecentActVo;
import com.example.trelloweb.user.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActService {
    private final ActJPARepo actJPRepo;
    private final UserService userService;

    public void create(String useruid, String category){
        RecentActVo recentActVo = new RecentActVo();
        recentActVo.setUservo(userService.findByUSER_UID(useruid).orElse(null));
        recentActVo.setActCategory(category);
        actJPRepo.save(recentActVo);
    }
}
