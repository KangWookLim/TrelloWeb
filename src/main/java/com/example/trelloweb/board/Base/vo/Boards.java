package com.example.trelloweb.board.Base.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boards {
    private Integer USER_UID;

    private Integer WS_ID;

    private Integer BOARD_ID;

    private String WS_role;

    private String WS_created_date;

    private String WS_IMG_URL;

    private String WS_NAME;

    private String Board_NAME;

    private String Board_Access;

    private String Board_Description;

    private String Board_Image_url;

}
