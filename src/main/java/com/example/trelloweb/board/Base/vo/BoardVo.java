package com.example.trelloweb.board.Base.vo;

import com.example.trelloweb.board.board_mem.vo.Board_memVo;
import com.example.trelloweb.list.vo.ListVo;
import com.example.trelloweb.workspace.Base.vo.WorkSpaceVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "Board")
public class BoardVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long BoardId;

    @ManyToOne
    @JoinColumn(name = "WS_ID")
    private WorkSpaceVo WS_ID;

    @Column(length = 100, nullable = false)
    private String BoardName;

    private String image_URL;

    @Column(length = 500) @ColumnDefault("'My_Board'")
    private String description;

    @OneToMany(mappedBy = "boardvo", cascade = CascadeType.REMOVE)
    @Column(name = "board_member_id")
    private List<Board_memVo> board_memVoList;

    @OneToMany(mappedBy = "boardvo", cascade = CascadeType.REMOVE)
    @Column(name = "list_id")
    private List<ListVo> listVoList;
}
