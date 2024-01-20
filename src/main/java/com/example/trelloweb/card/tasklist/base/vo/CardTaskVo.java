package com.example.trelloweb.card.tasklist.base.vo;

import com.example.trelloweb.card.base.vo.CardVo;
import com.example.trelloweb.card.tasklist.item.vo.TaskitemVO;
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
public class CardTaskVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Task_id")
    private Long Taskid;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @Column(nullable = false)
    private String title;

    @CreatedDate
    private LocalDateTime createddate;

    @OneToMany(mappedBy = "cardtaskvo", cascade = CascadeType.REMOVE)
    private List<TaskitemVO> taskItemList;
}
