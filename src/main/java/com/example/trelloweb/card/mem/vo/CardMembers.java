package com.example.trelloweb.card.mem.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardMembers {
    private Long card_id;
    private String user_uid;
    private String nickname;
}
