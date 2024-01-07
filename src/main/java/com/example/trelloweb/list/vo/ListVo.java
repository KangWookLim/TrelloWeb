package com.example.trelloweb.list.vo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.card.base.vo.CardVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity(name = "List")
@AllArgsConstructor
@RequiredArgsConstructor
public class ListVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long List_Id;

    private int list_order;

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Board_Id")
    private BoardVo boardvo;

    @OneToMany(mappedBy = "list_id", cascade = CascadeType.REMOVE)
    private List<CardVo> cardVoList;
}
