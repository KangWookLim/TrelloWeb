package com.example.trelloweb.user.Recent_Act.entity;

import com.example.trelloweb.user.base.entity.UserVo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing
@Entity(name = "User_Recent_Act")
public class RecentActVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_uid")
    private UserVo uservo;

    @Column(name = "act_uri")
    private String actUri;

    @CreatedDate
    @Column(name = "act_date")
    private LocalDateTime ActDate;
}
