package com.example.trelloweb.list.vo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.card.base.vo.CardVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

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
    @JsonBackReference
    private BoardVo boardvo;

    @OneToMany(mappedBy = "listid", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy("cardorder ASC")
    @JsonManagedReference
    private List<CardVo> cardVoList;
}
