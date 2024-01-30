package com.example.trelloweb.board.board_mem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Board_memPk implements Serializable {
    private String uservo;
    private Long boardvo;
}
