package com.example.trelloweb.board.Base.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boards {
    private Integer WS_ID;

    private String WS_NAME;

    private String WS_IMG;

    private String WS_ROLE;

    private String WS_DATE;

    private Integer BOARD_ID;

    private String BOARD_NAME;

    private String BOARD_IMG;

    private String BOARD_DES;

    private String BOARD_ACCESS;
}
