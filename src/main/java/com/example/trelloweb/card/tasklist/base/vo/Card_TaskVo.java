package com.example.trelloweb.card.tasklist.base.vo;

import com.example.trelloweb.card.base.vo.CardVo;
import com.example.trelloweb.card.tasklist.item.vo.Task_itemVO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "card_task")
public class Card_TaskVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Task_id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @Column(nullable = false)
    private String title;

    @CreatedDate
    private LocalDateTime createddate;

    @OneToMany(mappedBy = "cardtaskvo", cascade = CascadeType.REMOVE)
    private List<Task_itemVO> task_ItemVOList;
}
