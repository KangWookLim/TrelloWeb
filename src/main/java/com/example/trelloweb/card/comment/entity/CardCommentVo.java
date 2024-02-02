package com.example.trelloweb.card.comment.entity;

import com.example.trelloweb.card.base.entity.CardVo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "Card_comment")
public class CardCommentVo {
    @Id
    @Column(name = "Card_Comment_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CardCommentId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_uid")
    private UserVo uservo;

    @Column(nullable = false)
    private String comment;

    @CreatedDate
    private LocalDateTime createdDate;

    private String origin_file_name;

    private String stored_file_name;
}
