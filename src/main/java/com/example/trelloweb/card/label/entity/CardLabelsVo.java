package com.example.trelloweb.card.label.entity;

import com.example.trelloweb.card.base.entity.CardVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "Card_Labels")
public class CardLabelsVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private Long labelid;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String color;
}
