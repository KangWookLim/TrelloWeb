package com.example.trelloweb.user.Blocked_User.vo;

import com.example.trelloweb.user.base.vo.UserVo;
import lombok.Data;

import java.io.Serializable;

@Data
public class blocked_user_pk implements Serializable {
    private String uservo;
    private String BlockingUSERUID;
}
