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

    public int removeCardMember(String user_uid, Long cardid) {
        return cardMemberRepo.removeCardMember(user_uid, cardid);
    }

    public int addCardMember(String userUid, Long cardId) {
        return cardMemberRepo.addCardMember(userUid, cardId);
    }
}
