package com.example.trelloweb.card.attatchments.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardAttachments {
    private String added_date;
    private Long att_board_id;
    private Long att_id;
    private Long card_id;
    private String origin_file_name;
    private String stored_file_name;
}
