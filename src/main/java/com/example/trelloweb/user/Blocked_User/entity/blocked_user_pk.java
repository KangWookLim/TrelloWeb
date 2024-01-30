package com.example.trelloweb.user.Blocked_User.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class blocked_user_pk implements Serializable {
    private String uservo;
    private String BlockingUSERUID;
}
