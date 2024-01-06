package com.example.trelloweb.list.vo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
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
}
