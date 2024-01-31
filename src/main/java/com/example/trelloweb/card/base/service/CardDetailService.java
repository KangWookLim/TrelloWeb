package com.example.trelloweb.card.base.service;

import com.example.trelloweb.card.base.repo.CardDetailRepo;
import com.example.trelloweb.card.base.vo.Cards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardDetailService {
    private final CardDetailRepo cardDetailRepo;
    public Cards getCardDetail(Long cardid) {
        return cardDetailRepo.getCardByCardId(cardid);
    }

    public int updateDueDate(Long cardId, String dueDate) {
        return cardDetailRepo.updateDueDate(cardId, dueDate);
    }

    public int removeDueDate(Long cardId) {
        return cardDetailRepo.removeDueDate(cardId);
    }
}
