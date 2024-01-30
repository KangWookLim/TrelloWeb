package com.example.trelloweb.user.Starred_Board.entity;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@IdClass(StarredBoardPK.class)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "User_Starred_Board")
public class StarredBoardVo {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_uid")
    @JsonBackReference
    private UserVo uservo;

    @Id
    @ManyToOne
    @JoinColumn(name = "Starred_Board_ID")
    @JsonBackReference
    private BoardVo boardVo;
}