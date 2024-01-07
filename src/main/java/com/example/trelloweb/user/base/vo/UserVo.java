package com.example.trelloweb.user.base.vo;

import com.example.trelloweb.board.board_mem.vo.Board_memVo;
import com.example.trelloweb.card.comment.vo.Card_CommentVo;
import com.example.trelloweb.card.mem.vo.Card_MemVo;
import com.example.trelloweb.user.Blocked_User.vo.Blocked_UserVo;
import com.example.trelloweb.user.Recent_Act.vo.Recent_ActVo;
import com.example.trelloweb.user.Starred_Board.vo.Starred_BoardVo;
import com.example.trelloweb.workspace.wsmem.vo.WorkSpaceMemVo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long USER_UID;

    @Column(length = 100, unique = true, nullable = false)
    private String ID;

    @Column(length = 100, nullable = false)
    private String PW;

    @Column
    private String IMG_URL;

    @Column(length = 100, unique = true, nullable = false)
    private String NICKNAME;

    @Column(length = 100, nullable = false)
    private String FULLNAME;

    @Column(length = 100, unique = true, nullable = false)
    private String EMAIL;

    @Column(length = 100)
    private String BIRTH;

    @ColumnDefault(value = "'M'")
    private char GENDER;

    @Column(length = 100, unique = true, nullable = false)
    private String PHONE;

    @CreatedDate
    private LocalDateTime CREATE_DATE;

    private LocalDateTime UPDATE_DATE;

    @Column(length = 1000)@ColumnDefault("'안녕하세요!'")
    private String BIO;

    @Column(nullable = true)
    private String SOCIAL_LINK_1;
    @Column(nullable = true)
    private String SOCIAL_LINK_2;
    @Column(nullable = true)
    private String SOCIAL_LINK_3;
    @Column(nullable = true)
    private String SOCIAL_LINK_4;

    @OneToMany(mappedBy = "Blocking_USER_UID", cascade = CascadeType.REMOVE)
    private List<Blocked_UserVo> blocking_userVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE)
    private List<Recent_ActVo> recent_actVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE)
    private List<Starred_BoardVo> starred_boardVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE)
    private List<WorkSpaceMemVo> workSpaceMemVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE)
    private List<Board_memVo> board_MemVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE)
    private List<Card_MemVo> card_MemVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE)
    private  List<Card_CommentVo> card_commentVoList;
}
