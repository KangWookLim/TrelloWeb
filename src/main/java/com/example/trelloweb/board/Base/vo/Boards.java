package com.example.trelloweb.board.Base.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer USER_UID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer WS_ID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BOARD_ID;

    @Column(length = 50)
    private String WS_role;

    @Column(length = 100)
    private String WS_created_date;

    @Column(length = 100)
    private String WS_IMG_URL;

    @Column(length = 100)
    private String WS_NAME;

    @Column(length = 100)
    private String Board_NAME;

    @Column(length = 100)
    private String Board_Access;

    @Column(length = 100)
    private String Board_Description;

    @Column(length = 100)
    private String Board_Image_url;




}
