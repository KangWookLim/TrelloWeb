package com.example.trelloweb.card.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cards {
    private Integer list_id;
    private Integer CARD_ORDER;
    private Long CARDID;
    private String created_date;
    private String updated_date;
    private String due_date;
    private String name;
    private String description;
    private String cover;
    private String listname;
}
