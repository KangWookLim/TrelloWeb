package com.example.trelloweb.user.Starred_Board.vo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "User_Starred_Board")
public class StarredBoardVo {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_uid")
    private UserVo uservo;

    @Id
    @ManyToOne
    @JoinColumn(name = "Starred_Board_ID")
    private BoardVo boardVo;
}
