package com.example.trelloweb.card.label.service;

import com.example.trelloweb.card.label.repo.CardLabelRepo;
import com.example.trelloweb.card.label.vo.CardLabels;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardLabelService {
    private final CardLabelRepo cardLabelRepo;
    public List<CardLabels> getLabels(Long cardid) {
        return cardLabelRepo.getLabels(cardid);
    }
}
