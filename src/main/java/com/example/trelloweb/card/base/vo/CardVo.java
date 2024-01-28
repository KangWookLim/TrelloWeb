package com.example.trelloweb.card.base.vo;

import com.example.trelloweb.card.attatchments.vo.Card_attatchmentVo;
import com.example.trelloweb.card.comment.vo.CardCommentVo;
import com.example.trelloweb.card.label.vo.CardLabelsVo;
import com.example.trelloweb.card.mem.vo.CardMemVo;
import com.example.trelloweb.card.tasklist.base.vo.CardTaskVo;
import com.example.trelloweb.list.vo.ListVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity(name = "card")
public class CardVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardid;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private ListVo listid;

    @Column(name = "card_order")
    private int cardorder;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 1000)
    @ColumnDefault(value = "'My Card'")
    private String description;

    private LocalDateTime due_date;

    private String cover;

    @CreatedDate
    private LocalDateTime created_date;

    private LocalDateTime updated_date;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CardLabelsVo> card_labelsVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CardMemVo> card_memVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Card_attatchmentVo> card_attatchmentVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CardCommentVo> card_commentVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CardTaskVo> card_taskVoList;

}
