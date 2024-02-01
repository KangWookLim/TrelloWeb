package com.example.trelloweb.card.attatchments.entity;

import com.example.trelloweb.card.base.entity.CardVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "att_id")
    private Long attid;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @CreatedDate
    @Column(name = "added_date")
    private LocalDateTime addeddate;

    @Column(name = "origin_file_name")
    private String originfilename;

    @Column(name = "stored_file_name")
    private String storedfilename;

    @Column(name = "att_board_id")
    private Long attboardid;
}
