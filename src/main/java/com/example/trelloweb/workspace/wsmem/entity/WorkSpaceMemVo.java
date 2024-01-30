package com.example.trelloweb.workspace.wsmem.entity;

import com.example.trelloweb.user.base.entity.UserVo;
import com.example.trelloweb.workspace.Base.entity.WorkSpaceVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;


@Getter
@Setter
@IdClass(WS_MEM_Pk.class)
@Entity(name = "WS_Members")
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkSpaceMemVo {
    @Id
    @ManyToOne
    @JoinColumn(name = "USER_UID")
    @JsonBackReference
    private UserVo uservo;

    @Id
    @ManyToOne
    @JoinColumn(name = "WS_ID")
    @JsonBackReference
    private WorkSpaceVo WSID;

    @Column(nullable = false) @ColumnDefault("'Normal'")
    private String Role;
}
