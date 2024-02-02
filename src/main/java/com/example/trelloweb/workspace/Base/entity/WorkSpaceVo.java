package com.example.trelloweb.workspace.Base.entity;

import com.example.trelloweb.board.Base.entity.BoardVo;
import com.example.trelloweb.workspace.wsmem.entity.WorkSpaceMemVo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "Workspace")
@RequiredArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class WorkSpaceVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WS_ID")
    private Long workspaceId;

    @Column(name = "name", length = 40, nullable = false)
    private String workspacename;

    @CreatedDate
    private LocalDateTime Created_Date;

    private String IMG_URL;

    @OneToMany(mappedBy = "WSID", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<WorkSpaceMemVo> workspaceMem;

    @OneToMany(mappedBy = "WSID", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BoardVo> boardVoList;
}


