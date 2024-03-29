package com.example.trelloweb.card.tasklist.item.entity;

import com.example.trelloweb.card.tasklist.base.entity.CardTaskVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "task_item")
public class TaskitemVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_item_id")
    private Long taskitemid;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "task_id")
    private CardTaskVo cardtaskvo;

    @Column(nullable = false)
    private String title;

    private boolean isChecked;
}
