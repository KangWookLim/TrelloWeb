package com.example.trelloweb.card.attatchments.service;

import com.example.trelloweb.card.attatchments.repo.CardAttachmentRepo;
import com.example.trelloweb.card.attatchments.vo.CardAttachments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardAttachmentService {
    private final CardAttachmentRepo cardAttachmentRepo;

    public List<CardAttachments> getAttachments(Long cardid){
        return cardAttachmentRepo.getAttachments(cardid);
    }
}
