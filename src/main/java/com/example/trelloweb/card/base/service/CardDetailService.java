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
}
