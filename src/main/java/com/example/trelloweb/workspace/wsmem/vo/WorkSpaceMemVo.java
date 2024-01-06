package com.example.trelloweb.workspace.wsmem.vo;

import com.example.trelloweb.user.base.vo.UserVo;
import com.example.trelloweb.workspace.Base.vo.WorkSpaceVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


@IdClass(WS_MEM_Pk.class)
@Entity(name = "WS_Members")
@Data
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
    private WorkSpaceVo WS_ID;

    @Column(nullable = false) @ColumnDefault("'Nomal'")
    private String Role;
}
