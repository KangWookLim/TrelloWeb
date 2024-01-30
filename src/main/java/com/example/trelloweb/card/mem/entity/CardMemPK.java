package com.example.trelloweb.card.mem.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CardMemPK implements Serializable {
    private String uservo;
    private Long cardvo;
}
