package com.example.trelloweb.user.Blocked_User.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class blocked_user_pk implements Serializable {
    private String uservo;
    private String BlockedUSERUID;
}
