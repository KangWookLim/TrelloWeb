package com.example.trelloweb.card.comment.service;

import com.example.trelloweb.card.base.entity.CardVo;
import com.example.trelloweb.card.base.repo.CardDetailJPARepo;
import com.example.trelloweb.card.comment.entity.CardCommentVo;
import com.example.trelloweb.card.comment.repo.CardCommentJPARepo;
import com.example.trelloweb.card.comment.repo.CardCommentRepo;
import com.example.trelloweb.card.comment.vo.CardComments;
import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.user.base.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardCommentService {
    private final CardCommentRepo cardCommentRepo;
    private final CardDetailJPARepo cardDetailJPARepo;
    private final UserJpaRepo userJpaRepo;
    private final CardCommentJPARepo cardCommentJPARepo;

    public List<CardComments> getComments(Long cardid) {
        return cardCommentRepo.getComments(cardid);
    }


    public void addComment(Long cardId, String comment, String user_uid) {
        CardVo cardVo = cardDetailJPARepo.findById(cardId).orElse(null);
        UserVo userVo = userJpaRepo.findById(user_uid).orElse(null);
        CardCommentVo cardCommentVo = new CardCommentVo();
        cardCommentVo.setComment(comment);
        cardCommentVo.setCreatedDate(LocalDateTime.now());
        cardCommentVo.setUservo(userVo);
        cardCommentVo.setCardvo(cardVo);
        cardCommentJPARepo.save(cardCommentVo);
    }
}
