package com.example.trelloweb.card.attatchments.vo;

import com.example.trelloweb.card.base.vo.CardVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name="card_attatchments")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Card_attatchmentVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long att_id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @CreatedDate
    private LocalDateTime added_date;

    private String origin_file_name;

    private String stored_file_name;
}
