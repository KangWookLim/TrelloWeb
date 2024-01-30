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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
