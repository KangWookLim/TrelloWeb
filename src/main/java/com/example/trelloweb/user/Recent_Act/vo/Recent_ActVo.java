package com.example.trelloweb.user.Recent_Act.vo;

import com.example.trelloweb.user.base.vo.UserVo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "User_Recent_Act")
public class Recent_ActVo {
    @Id
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_uid")
    private UserVo uservo;

    private String Act_Category;

    @CreatedDate
    private LocalDateTime Act_Date;
}
