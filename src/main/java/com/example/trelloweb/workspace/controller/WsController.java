package com.example.trelloweb.workspace.controller;

import com.example.trelloweb.user.base.service.UserService;
import com.example.trelloweb.workspace.Base.service.WsService;
import com.example.trelloweb.workspace.wsmem.service.WsMemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class WsController {
    private final WsService wsService;
    private final WsMemService wsMemService;
    private final UserService userService;
    @RequestMapping("/board")
    @ResponseBody
    public void getWS(){
    }

    @GetMapping("/ws/{WsId}")
    public ModelAndView boardWs(@RequestParam("WsId") Integer WsId, Principal principal) {
        ModelAndView view = new ModelAndView();

        return view;
    }

    @PostMapping("/ws/create")
    public ModelAndView createWS(@RequestParam("WsName") String WsName, @RequestParam("ImgUrl") String ImgUrl, Principal principal) {
        ModelAndView view = new ModelAndView();
        wsMemService.create(wsService.createWS(WsName,  ImgUrl),userService.findByUSER_UID(principal.getName()).get());
        view.setViewName("redirect:/board");
        return view;
    }
}
