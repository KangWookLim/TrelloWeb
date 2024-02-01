package com.example.trelloweb.card.tasklist.base.service;

import com.example.trelloweb.card.tasklist.base.repo.CardTaskJpaRepo;
import com.example.trelloweb.card.tasklist.base.repo.CardTaskRepo;
import com.example.trelloweb.card.tasklist.base.vo.CardTasks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardTaskServicve {
    private final CardTaskRepo cardTaskRepo;
    private final CardTaskJpaRepo cardTaskJpaRepo;

    public List<CardTasks> getCardTasks(Long cardid) {
        return cardTaskRepo.getAllTasks(cardid);
    }

    public int insertChecklist(Long cardId, String checklistValue) {
        return cardTaskRepo.insertChecklist(cardId, checklistValue);
    }

    /*public int removeTask(Long taskId) {
        return
        //return cardTaskRepo.removeTask(taskId);
    }*/
    public void removeTask(Long taskId) {
        cardTaskJpaRepo.deleteById(taskId);

    }
}
