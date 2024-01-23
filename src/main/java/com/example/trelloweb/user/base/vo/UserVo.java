package com.example.trelloweb.user.base.vo;

import com.example.trelloweb.board.board_mem.vo.Board_memVo;
import com.example.trelloweb.card.comment.vo.CardCommentVo;
import com.example.trelloweb.card.mem.vo.CardMemVo;
import com.example.trelloweb.user.Blocked_User.vo.Blocked_UserVo;
import com.example.trelloweb.user.Recent_Act.vo.RecentActVo;
import com.example.trelloweb.user.Starred_Board.vo.StarredBoardVo;
import com.example.trelloweb.workspace.wsmem.vo.WorkSpaceMemVo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity(name = "users")
public class UserVo {

    @Id
    @Column(name = "user_uid")
    private String useruid;

    @Column(unique = true, nullable = false)
    private String ID;

    @Column(length = 100)
    private String PW;

    @Column(length = 100, nullable = false)
    private String EMAIL;

    @Column(name = "img_url")
    @ColumnDefault("'images/profile/user.png'")
    private String IMGURL;

    @Column(length = 100, unique = true)
    private String NICKNAME;

    @Column(length = 100, nullable = false)
    private String FULLNAME;

    @Column(length = 100)
    private String BIRTH;

    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime CREATEDATE;

    @Column(name = "update_date")
    private LocalDateTime UPDATEDATE;

    @Column(length = 1000)
    private String BIO;

    @Column(nullable = true, name = "social_link_1")
    private String SOCIALLINK1;
    @Column(nullable = true, name = "social_link_2")
    private String SOCIALLINK2;
    @Column(nullable = true, name = "social_link_3")
    private String SOCIALLINK3;
    @Column(nullable = true, name = "social_link_4")
    private String SOCIALLINK4;

    @OneToMany(mappedBy = "BlockingUSERUID", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Blocked_UserVo> blocking_userVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<RecentActVo> recentactVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<StarredBoardVo> starredboardVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<WorkSpaceMemVo> workSpaceMemVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Board_memVo> boardMemVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CardMemVo> cardMemVoList;

    @OneToMany(mappedBy = "uservo", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private  List<CardCommentVo> cardcommentVoList;


    @PrePersist
    public void prePersist() {
        if (this.useruid == null) {
            this.useruid = generateUuid();
        }
    }

    private String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
