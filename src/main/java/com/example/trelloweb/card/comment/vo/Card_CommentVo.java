package com.example.trelloweb.card.comment.vo;

import com.example.trelloweb.card.base.vo.CardVo;
import com.example.trelloweb.user.base.vo.UserVo;
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
public class Card_CommentVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Card_Comment_Id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardVo cardvo;

    @ManyToOne
    @JoinColumn(name = "user_uid")
    private UserVo uservo;

    @Column(nullable = false)
    private String comment;

    @CreatedDate
    private LocalDateTime createdDate;

    private String origin_file_name;

    private String stored_file_name;
}
