package com.example.trelloweb.list.controller;

import com.example.trelloweb.list.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/list_detail")
public class ListDetailController {
    private final ListService listService;

    @RequestMapping("/getMaxListOrder")
    @ResponseBody
    public int getMaxListOrder(@RequestParam("board_id") Long boardId){
        return listService.getMaxListOrder(boardId);
    }

    @RequestMapping("/addList")
    @ResponseBody
    public void addList(@RequestParam("board_id") Long board_id, @RequestParam ("list_name") String list_name, @RequestParam ("order") Integer order){
        listService.addList(board_id, list_name, order);
    }

    @RequestMapping("/reorderList")
    @ResponseBody
    public void reorderList(@RequestParam ("list_id") Long list_id, @RequestParam ("order") Integer order){
        listService.reorderList(list_id, order);
    }

    @RequestMapping("/removeList")
    @ResponseBody
    public void removeList(@RequestParam("listId") Long ListId){
        listService.removeList(ListId);
    }

    @RequestMapping("/editListTitle")
    @ResponseBody
    public void editListTitle(@RequestParam("Title") String title, @RequestParam("listId") Long listId){
        listService.editListTitle(title,listId);
    }
}
