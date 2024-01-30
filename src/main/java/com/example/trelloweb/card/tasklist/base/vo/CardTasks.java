package com.example.trelloweb.card.tasklist.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTasks {
    private Long card_id;
    private String createddate;
    private Long task_id;
    private String title;
}
