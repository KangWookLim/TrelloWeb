//package com.example.trelloweb.user.Recent_Act.controller;
//
//import com.example.trelloweb.boarddetail.service.BoardDetailService;
//import com.example.trelloweb.user.Recent_Act.service.ActService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.security.Principal;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/{category}")
//public class ActRestController {
//    private final BoardDetailService boardDetailService;
//    private final ActService actService;
//
//    @RequestMapping("/{boardName}")
//    public void actDetail(@PathVariable String boardName, @PathVariable String category, Principal principal) {
//        System.out.println(boardName+category);
//        actService.create(principal.getName(), category);
//    }
//
//}
