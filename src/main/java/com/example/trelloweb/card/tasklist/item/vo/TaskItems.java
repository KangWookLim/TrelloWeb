package com.example.trelloweb.card.tasklist.item.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskItems {
    private Boolean is_checked;
    private Long task_id;
    private Long task_item_id;
    private String title;
}
