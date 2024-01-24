package com.example.trelloweb.workspace.Base.vo;

import com.example.trelloweb.board.Base.vo.BoardVo;
import com.example.trelloweb.workspace.wsmem.vo.WorkSpaceMemVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "Workspace")
@RequiredArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class WorkSpaceVo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "WS_ID")
    private Long workspaceId;

    @Column(name = "name", length = 40, nullable = false)
    private String workspacename;

    @CreatedDate
    private LocalDateTime Created_Date;

    private String IMG_URL;

    @OneToMany(mappedBy = "WSID", cascade = CascadeType.REMOVE)
    private List<WorkSpaceMemVo> workspaceMem;

    @OneToMany(mappedBy = "WSID", cascade = CascadeType.REMOVE)
    private List<BoardVo> boardVoList;
}


