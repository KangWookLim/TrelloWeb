package com.example.trelloweb.board.board_mem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Board_memPk implements Serializable {
    private String uservo;
    private Long boardvo;
}
