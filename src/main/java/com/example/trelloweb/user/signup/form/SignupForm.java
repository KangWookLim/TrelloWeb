package com.example.trelloweb.user.signup.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupForm {
    @Size(min = 3, max = 25, message = "아이디 길이는 3~25 글자 사이입니다")
    @NotEmpty(message = "ID를 입력해주세요")
    private String id;

    @Size(min = 3, max = 20, message = "비밀번호 길이는 3~25글자 사이입니다")
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String pw;

    @NotEmpty(message = "비밀번호를 확인해주세요")
    private String pwcheck;

    @NotEmpty(message = "닉네임을 입력해주세요")
    private String nickname;

    @NotEmpty(message = "이름을 입력해주세요")
    private String fullname;

    @NotEmpty(message = "연락처를 입력해주세요")
    private String phone;

    @NotEmpty(message = "이메일을 입력해주세요")
    private String EMAIL;

    private String IMG_URL;

    private String BIRTH;

    private char GENDER;

    @Size(max = 1000, message = "자기소개가 너무 깁니다")
    private String BIO;

    private String SOCIAL_LINK_1;

    private String SOCIAL_LINK_2;

    private String SOCIAL_LINK_3;

    private String SOCIAL_LINK_4;
}
