package com.example.trelloweb.board.board_mem.vo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@IdClass(Board_memPk.class)
@Data
@DynamicInsert
@DynamicUpdate
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "Board_member")
public class Board_memVo {
    @Id
    @ManyToOne
    @JoinColumn(name = "USER_UID")
    private UserVo uservo;

    @Id
    @ManyToOne
    @JoinColumn(name = "Board_Id")
    private BoardVo boardvo;

    @Column(nullable = false, name = "board_access") @ColumnDefault("'Normal'")
    private String Boardaccess;
}
