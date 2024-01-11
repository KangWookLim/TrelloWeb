package com.example.trelloweb.user.signup.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupForm {
    @Size(min = 3, max = 25, message = "아이디 길이는 3~25 글자 사이입니다")
    @NotEmpty(message = "ID를 입력해주세요")
    private String id;

    @Size(min = 3, max = 20, message = "비밀번호 길이는 3~25글자 사이입니다")
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String pw;

    @NotEmpty(message = "비밀번호를 확인해주세요")
    private String pwcheck;

    @NotEmpty(message = "이름을 입력해주세요")
    private String fullname;

    @NotEmpty(message = "닉네임을 입력해주세요")
    private String nickname;

    @NotEmpty(message = "연락처를 입력해주세요")
    private String phone;

    private String BIRTH;

    private String EMAIL;

    @NotEmpty(message = "성별을 선택해주세요")
    private String GENDER;

    @Size(max = 500, message = "자기소개는 500자 이하입니다")
    private String BIO;
}
