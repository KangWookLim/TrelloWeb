package com.example.trelloweb.user.Blocked_User.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class BlockedUserInfo implements Serializable {
    private String useruid;
    private String NICKNAME;
    private String IMGURL;
}
