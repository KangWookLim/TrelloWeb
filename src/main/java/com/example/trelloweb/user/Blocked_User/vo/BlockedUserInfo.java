package com.example.trelloweb.user.Blocked_User.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class BlockedUserInfo implements Serializable {
    private String NickName;
    private String img_Url;
}
