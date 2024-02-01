package com.example.trelloweb.card.base.service;

import com.example.trelloweb.card.base.repo.CardDetailJPARepo;
import com.example.trelloweb.card.base.repo.CardDetailRepo;
import com.example.trelloweb.card.base.vo.Cards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardDetailService {
    private final CardDetailRepo cardDetailRepo;
    private final CardDetailJPARepo cardDetailJPARepo;

    public Cards getCardDetail(Long cardid) {
        return cardDetailRepo.getCardByCardId(cardid);
    }

    public int updateDueDate(Long cardId, String dueDate) {
        return cardDetailRepo.updateDueDate(cardId, dueDate);
    }

    public int removeDueDate(Long cardId) {
        return cardDetailRepo.removeDueDate(cardId);
    }

    public int addCover(String cover, Long cardId) {
        return cardDetailRepo.addCover(cardId, cover);
    }
    public int removeCover(Long cardId) {
        return cardDetailRepo.removeCover(cardId);
    }

    public int description(String description, Long cardId) {
        return cardDetailRepo.description(description, cardId);
    }

    public void removeCard(Long cardId) {
        cardDetailJPARepo.deleteById(cardId);
    }

    public int getOrderMax(Long listId) {
        return cardDetailRepo.getOrderMax(listId);
    }
}
