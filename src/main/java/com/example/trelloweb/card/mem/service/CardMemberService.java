package com.example.trelloweb.card.mem.service;

import com.example.trelloweb.card.mem.repo.CardMemberRepo;
import com.example.trelloweb.card.mem.vo.CardMembers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardMemberService {
    private final CardMemberRepo cardMemberRepo;
    public List<CardMembers> getCardMember(Long cardid) {
        return cardMemberRepo.getCardMember(cardid);
    }
}
