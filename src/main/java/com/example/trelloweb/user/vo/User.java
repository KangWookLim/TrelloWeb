package com.example.trelloweb.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int USER_UID;
    private String ID;
    private String PW;
    private String IMG;
    private String NICKNAME;
    private String FULLNAME;
    private String EMAIL;
    private String BIRTH;
    private String GENDER;
    private String PHONE;
    private String CREATE_DATE;
    private String BIO;
    private String SOCIAL_LINK_1;
    private String SOCIAL_LINK_2;
    private String SOCIAL_LINK_3;
    private String SOCIAL_LINK_4;
}
