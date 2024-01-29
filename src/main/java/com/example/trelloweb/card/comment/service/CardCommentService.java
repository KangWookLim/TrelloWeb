package com.example.trelloweb.card.comment.service;

import com.example.trelloweb.card.comment.repo.CardCommentRepo;
import com.example.trelloweb.card.comment.vo.CardComments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardCommentService {
    private final CardCommentRepo cardCommentRepo;
    public List<CardComments> getComments(Long cardid) {
        return cardCommentRepo.getComments(cardid);
    }


}
