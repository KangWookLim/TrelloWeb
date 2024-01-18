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
    @Column(name = "List_id")
    private Long ListId;

    @Column(name = "list_order")
    private int listorder;

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Board_Id")
    private BoardVo boardvo;

    @OneToMany(mappedBy = "listid", cascade = CascadeType.REMOVE)
    @OrderBy("cardorder ASC")
    private List<CardVo> cardVoList;
}
