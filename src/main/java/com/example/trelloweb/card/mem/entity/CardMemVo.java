package com.example.trelloweb.card.mem.entity;

import com.example.trelloweb.card.base.entity.CardVo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@IdClass(CardMemPK.class)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "card_members")
public class CardMemVo {
    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @Id
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_uid")
    private UserVo uservo;
}
