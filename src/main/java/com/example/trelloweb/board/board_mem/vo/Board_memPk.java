package com.example.trelloweb.board.board_mem.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Board_memPk implements Serializable {
    private Long USER_UID;
    private Long Board_ID;
}
