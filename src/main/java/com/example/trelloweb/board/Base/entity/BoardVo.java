package com.example.trelloweb.board.Base.entity;

import com.example.trelloweb.board.board_mem.entity.Board_memVo;
import com.example.trelloweb.list.entity.ListVo;
import com.example.trelloweb.workspace.Base.entity.WorkSpaceVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@RequiredArgsConstructor
@Entity(name = "Board")
public class BoardVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long BoardId;

    @ManyToOne
    @JoinColumn(name = "WS_ID")
    @JsonBackReference
    private WorkSpaceVo WSID;

    @Column(length = 100, nullable = false)
    private String boardName;

    @Column(name="image_URL")
    private String imageURL;

    @Column(length = 500) @ColumnDefault("'My_Board'")
    private String description;

    @OneToMany(mappedBy = "boardvo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Board_memVo> board_memVoList;

    @OneToMany(mappedBy = "boardvo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ListVo> listVoList;

}
