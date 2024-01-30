package com.example.trelloweb.user.Starred_Board.entity;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.user.base.entity.UserVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StarredBoardPK implements Serializable {
    private String uservo;
    private Long boardVo;
}
