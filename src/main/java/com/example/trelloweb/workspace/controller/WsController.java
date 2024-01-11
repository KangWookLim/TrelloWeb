package com.example.trelloweb.workspace.controller;

import com.example.trelloweb.workspace.Base.service.WsService;
import com.example.trelloweb.workspace.Base.vo.WorkSpaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class WsController {
    private final WsService wsService;
    @RequestMapping("/board")
    @ResponseBody
    public void getWS(){


    }
}
