package com.example.trelloweb.board.Base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSpaces {
    private Integer WS_ID;

    private String WS_NAME;

    private String WS_IMG;

    private String WS_ROLE;

    private String WS_DATE;
}
