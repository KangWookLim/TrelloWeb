package com.example.trelloweb.card.label.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardLabels {
    private Long card_id;
    private Long label_id;
    private String color;
    private String title;
}