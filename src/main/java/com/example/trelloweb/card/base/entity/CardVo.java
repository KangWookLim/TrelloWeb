package com.example.trelloweb.card.base.entity;

import com.example.trelloweb.card.attatchments.entity.Card_attatchmentVo;
import com.example.trelloweb.card.comment.entity.CardCommentVo;
import com.example.trelloweb.card.label.entity.CardLabelsVo;
import com.example.trelloweb.card.mem.entity.CardMemVo;
import com.example.trelloweb.card.tasklist.base.entity.CardTaskVo;
import com.example.trelloweb.list.entity.ListVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity(name = "card")
public class CardVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardid;

    @ManyToOne
    @JoinColumn(name = "list_id")
    @JsonBackReference
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

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<CardLabelsVo> card_labelsVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<CardMemVo> card_memVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Card_attatchmentVo> card_attatchmentVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<CardCommentVo> card_commentVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<CardTaskVo> card_taskVoList;

}
