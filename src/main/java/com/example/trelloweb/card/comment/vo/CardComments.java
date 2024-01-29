package com.example.trelloweb.card.comment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardComments {
    private Long card_comment_id;
    private Long card_id;
    private String created_date;
    private String comment;
    private String user_uid;
}
