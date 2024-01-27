package com.example.trelloweb.board.Base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarredBoards {
    private Integer WS_ID;

    private String WS_NAME;

    private Integer BOARD_ID;

    private String BOARD_NAME;

    private String BOARD_IMG;

}
