package com.example.trelloweb.user.Blocked_User.entity;

import com.example.trelloweb.user.base.entity.UserVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
    @JsonBackReference
    private UserVo uservo;

    @Id
    @ManyToOne
    @JoinColumn(name = "blocked_user_uid")
    @JsonBackReference
    private UserVo BlockedUSERUID;

    @Column
    private LocalDateTime BlockedTime;
}
