package com.example.trelloweb.card.base.vo;

import com.example.trelloweb.card.attatchments.vo.Card_attatchmentVo;
import com.example.trelloweb.card.comment.vo.Card_CommentVo;
import com.example.trelloweb.card.label.vo.Card_LabelsVo;
import com.example.trelloweb.card.mem.vo.Card_MemVo;
import com.example.trelloweb.card.tasklist.base.vo.Card_TaskVo;
import com.example.trelloweb.list.vo.ListVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "card")
public class CardVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long card_id;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ListVo list_id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 1000)
    @ColumnDefault(value = "'My Card'")
    private String description;

    private LocalDateTime due_date;

    private String cover;

    @CreatedDate
    private LocalDateTime created_date;

    private LocalDateTime updated_date;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    private List<Card_LabelsVo> card_labelsVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    private List<Card_MemVo> card_memVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    private List<Card_attatchmentVo> card_attatchmentVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    private List<Card_CommentVo> card_commentVoList;

    @OneToMany(mappedBy = "cardvo", cascade = CascadeType.REMOVE)
    private List<Card_TaskVo> card_taskVoList;

}
