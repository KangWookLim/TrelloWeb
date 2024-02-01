package com.example.trelloweb.board.board_mem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class Board_memPk implements Serializable {
    private String uservo;
    private Long boardvo;

}
