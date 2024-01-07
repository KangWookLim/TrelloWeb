package com.example.trelloweb.card.mem.vo;

import com.example.trelloweb.card.base.vo.CardVo;
import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@IdClass(Card_MemPK.class)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "card_members")
public class Card_MemVo {
    @Id
    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_uid")
    private UserVo uservo;
}
