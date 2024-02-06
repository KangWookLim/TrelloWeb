package com.example.trelloweb.card.base.service;

import com.example.trelloweb.card.base.entity.CardVo;
import com.example.trelloweb.card.base.repo.CardDetailJPARepo;
import com.example.trelloweb.card.base.repo.CardDetailRepo;
import com.example.trelloweb.card.base.vo.Cards;
import com.example.trelloweb.list.entity.ListVo;
import com.example.trelloweb.list.repo.ListJPARepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardDetailService {
    private final CardDetailRepo cardDetailRepo;
    private final CardDetailJPARepo cardDetailJPARepo;
    private final ListJPARepo listJPARepo;

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

    public void addCardtoList(Integer cardOrder, Long listId, String cardName) {
        ListVo listVo = listJPARepo.findById(listId).orElse(null);
        CardVo cardVo = new CardVo();
        cardVo.setCardorder(cardOrder);
        cardVo.setListid(listVo);
        cardVo.setName(cardName);
        cardDetailJPARepo.save(cardVo);



    }

    public int name(String name, Long cardId) {
        return cardDetailRepo.name(name, cardId);
    }

    public void moveCard(Long cardId, Long listId) {
        ListVo listVo = listJPARepo.findById(listId).orElse(null);
        CardVo cardVo = cardDetailJPARepo.findById(cardId).orElse(null);
        cardVo.setListid(listVo);
        cardDetailJPARepo.save(cardVo);
    }

    public void reorderCard(Long cardId, Integer cardOrder) {
        CardVo cardVo = cardDetailJPARepo.findById(cardId).orElse(null);
        cardVo.setCardorder(cardOrder);
        cardDetailJPARepo.save(cardVo);
    }
}
