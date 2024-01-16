package com.example.trelloweb.card.label.vo;

import com.example.trelloweb.card.base.vo.CardVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "Card_Labels")
public class Card_LabelsVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long label_id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @ColumnDefault(value = "null")
    private String title;

    @Column(nullable = false)
    private String color;
}
