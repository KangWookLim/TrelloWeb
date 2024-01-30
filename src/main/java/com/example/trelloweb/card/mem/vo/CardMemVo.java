package com.example.trelloweb.card.mem.vo;

import com.example.trelloweb.card.base.vo.CardVo;
import com.example.trelloweb.user.base.entity.UserVo;
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
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_uid")
    private UserVo uservo;
}
