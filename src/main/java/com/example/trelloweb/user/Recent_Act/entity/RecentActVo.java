package com.example.trelloweb.user.Recent_Act.entity;

import com.example.trelloweb.user.base.entity.UserVo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "User_Recent_Act")
public class RecentActVo {
    @Id
    private Long Id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_uid")
    private UserVo uservo;

    @Column(name = "act_category")
    private String ActCategory;

    @CreatedDate
    @Column(name = "act_date")
    private LocalDateTime ActDate;
}
