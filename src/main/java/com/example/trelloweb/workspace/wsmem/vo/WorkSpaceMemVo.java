package com.example.trelloweb.workspace.wsmem.vo;

import com.example.trelloweb.user.base.vo.UserVo;
import com.example.trelloweb.workspace.Base.vo.WorkSpaceVo;
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
    private UserVo uservo;

    @Id
    @ManyToOne
    @JoinColumn(name = "WS_ID")
    private WorkSpaceVo WSID;

    @Column(nullable = false) @ColumnDefault("'Normal'")
    private String Role;
}
