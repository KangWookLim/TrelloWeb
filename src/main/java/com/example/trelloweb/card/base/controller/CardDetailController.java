package com.example.trelloweb.card.base.controller;

import com.example.trelloweb.card.attatchments.service.CardAttachmentService;
import com.example.trelloweb.card.attatchments.vo.CardAttachments;
import com.example.trelloweb.card.base.service.CardDetailService;
import com.example.trelloweb.card.base.vo.Cards;
import com.example.trelloweb.card.comment.service.CardCommentService;
import com.example.trelloweb.card.comment.vo.CardComments;
import com.example.trelloweb.card.label.service.CardLabelService;
import com.example.trelloweb.card.label.vo.CardLabels;
import com.example.trelloweb.card.mem.service.CardMemberService;
import com.example.trelloweb.card.mem.vo.CardMembers;
import com.example.trelloweb.card.tasklist.base.service.CardTaskServicve;
import com.example.trelloweb.card.tasklist.base.vo.CardTasks;
import com.example.trelloweb.card.tasklist.item.service.TaskItemService;
import com.example.trelloweb.card.tasklist.item.vo.TaskItems;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/card_detail")
public class CardDetailController {
    private final CardDetailService cardDetailService;
    private final CardMemberService cardMemberService;
    private final CardAttachmentService cardAttachmentService;
    private final CardLabelService cardLabelService;
    private final CardCommentService cardCommentService;
    private final CardTaskServicve cardTaskServicve;
    private final TaskItemService taskItemService;
    @RequestMapping("")
    @ResponseBody
    public Cards getCardDetail(@RequestParam("cardid") Long cardid){
        Cards cardvo = cardDetailService.getCardDetail(cardid);
        return cardvo;
    }

    @RequestMapping("/member")
    @ResponseBody
    public List<CardMembers> getCardMembers(@RequestParam("cardid") Long cardid){
        /*
           코드 간결화 아래는 결과물
        List<CardMembers> cardMembers = boardDetailService.getCardMember(cardid);
        return cardMembers;*/
        return cardMemberService.getCardMember(cardid);
    }
    @RequestMapping("/attachment")
    @ResponseBody
    public List<CardAttachments> getAttachments(@RequestParam("cardid") Long cardid){
        return cardAttachmentService.getAttachments(cardid);
    }

    @RequestMapping("/comment")
    @ResponseBody
    public List<CardComments> getComments(@RequestParam("cardid") Long cardid){
        return cardCommentService.getComments(cardid);
    }

    @RequestMapping("/label")
    @ResponseBody
    public List<CardLabels> getLabels(@RequestParam("cardid") Long cardid){
        return cardLabelService.getLabels(cardid);
    }

    @RequestMapping("/task")
    @ResponseBody
    public List<CardTasks> getCardTasks(@RequestParam("cardid") Long cardid){
        return cardTaskServicve.getCardTasks(cardid);
    }

    @RequestMapping("/task_items")
    @ResponseBody
    public List<TaskItems> getTaskItems(@RequestParam("taskid") Long taskid){
        return taskItemService.getTaskItems(taskid);
    }


    @RequestMapping("/removeMember")
    @ResponseBody
    public int removeMember(@RequestParam ("user_uid") String user_uid, @RequestParam ("cardid") Long cardid){
        return cardMemberService.removeCardMember(user_uid, cardid);
    }

    @RequestMapping("/addMember")
    @ResponseBody
    public int addMember(@RequestParam ("user_uid") String user_uid, @RequestParam ("card_id") Long card_id){
        return cardMemberService.addCardMember(user_uid,card_id);
    }

    @RequestMapping("/updateDueDate")
    @ResponseBody
    public int updateDueDate(@RequestParam ("card_id") Long card_id, @RequestParam ("due_date") String due_date){
        return cardDetailService.updateDueDate(card_id, due_date);
    }

    @RequestMapping("/removeDueDate")
    @ResponseBody
    public int removeDueDate(@RequestParam ("card_id") Long card_id){
        return cardDetailService.removeDueDate(card_id);
    }

    @RequestMapping("/insertChecklist")
    @ResponseBody
    public int insertChecklist(@RequestParam ("card_id") Long card_id, @RequestParam ("checklist_value") String checklist_value){
        return cardTaskServicve.insertChecklist(card_id, checklist_value);
    }

    @RequestMapping("/addCover")
    @ResponseBody
    public int addCover(@RequestParam ("cover") String cover, @RequestParam ("card_id") Long card_id){
        return cardDetailService.addCover(cover,card_id);
    }
    @RequestMapping("/removeCover")
    @ResponseBody
    public int removeCover(@RequestParam ("card_id") Long card_id){
        return cardDetailService.removeCover(card_id);
    }

    @RequestMapping("/description")
    @ResponseBody
    public int description(@RequestParam ("description") String description, @RequestParam ("card_id") Long card_id){
        return cardDetailService.description(description,card_id);
    }

    @RequestMapping("/name")
    @ResponseBody
    public int name(@RequestParam ("name") String name, @RequestParam ("card_id") Long card_id){
        return cardDetailService.name(name,card_id);
    }


    @RequestMapping("/deleteTask")
    @ResponseBody
    public void deleteTask(@RequestParam ("taskId") Long taskId){
        cardTaskServicve.removeTask(taskId);
    }

    @RequestMapping("/deleteCard")
    @ResponseBody
    public void deleteCard(@RequestParam ("cardId") Long cardId){
        cardDetailService.removeCard(cardId);
    }

    @RequestMapping("get_orderMax")
    @ResponseBody
    public int getOrderMax(@RequestParam ("list_id") Long list_id){
        return cardDetailService.getOrderMax(list_id);
    }

    @RequestMapping("addComment")
    @ResponseBody
    public void addComment(@RequestParam ("card_id") Long card_id, @RequestParam("comment") String comment, Principal principal){
        System.out.println(principal.getName() + "this is your current user_uid from principal");
        cardCommentService.addComment(card_id, comment, principal.getName());
    }

    @RequestMapping("addCardtoList")
    @ResponseBody
    public void addCardtoList(@RequestParam ("list_id") Long list_id, @RequestParam ("card_order") Integer card_order, @RequestParam("card_name") String card_name){
        cardDetailService.addCardtoList(card_order, list_id,card_name);
    }

    @RequestMapping("addItemtoTask")
    @ResponseBody
    public void addItemtoTask(@RequestParam ("taskid") Long task_id, @RequestParam("text") String title){
        taskItemService.addItemtoTask(task_id, title);
    }

    @RequestMapping("task_items_percent")
    @ResponseBody
    public int task_items_percent(@RequestParam ("taskid") Long task_id){
        return taskItemService.task_items_percent(task_id);
    }

    @RequestMapping("/setTaskItem")
    @ResponseBody
    public void setTaskItem(@RequestParam ("taskItemId") Long task_item_id, @RequestParam ("checked") Boolean checked){
        taskItemService.setTaskItem(task_item_id, checked);
    }

    @RequestMapping("/deleteTaskItem")
    @ResponseBody
    public void deleteTaskItem(@RequestParam ("taskItemId") Long task_item_id){
        taskItemService.deleteTaskItem(task_item_id);
    }

    @RequestMapping("/deleteComment")
    @ResponseBody
    public void deleteComment(@RequestParam ("card_comment_id") Long comment_id){
        cardCommentService.deleteComment(comment_id);
    }

    @RequestMapping("/moveCard")
    @ResponseBody
    public void moveCard(@RequestParam ("card_id") Long card_id, @RequestParam ("list_id") Long list_id){
        cardDetailService.moveCard(card_id, list_id);
    }

    @RequestMapping("/reorderCard")
    @ResponseBody
    public void reorderCard(@RequestParam ("card_id") Long card_id, @RequestParam ("order") Integer card_order){
        cardDetailService.reorderCard(card_id, card_order);
    }
}
