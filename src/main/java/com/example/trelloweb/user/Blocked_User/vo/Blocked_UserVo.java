package com.example.trelloweb.user.Blocked_User.vo;

import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@IdClass(blocked_user_pk.class)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "blocked_user")
public class Blocked_UserVo {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_uid")
    private UserVo uservo;

    @Id
    @ManyToOne
    @JoinColumn(name = "bolcking_user_uid", unique = true)
    private UserVo Blocking_USER_UID;

    @Column
    private LocalDateTime Blocked_Time;
}
