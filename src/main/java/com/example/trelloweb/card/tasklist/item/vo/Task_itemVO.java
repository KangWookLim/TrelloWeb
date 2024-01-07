package com.example.trelloweb.card.tasklist.item.vo;

import com.example.trelloweb.card.tasklist.base.vo.Card_TaskVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "task_itme")
public class Task_itemVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_itme_id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Card_TaskVo cardtaskvo;

    @Column(nullable = false)
    private String title;

    private boolean isChecked;
}
