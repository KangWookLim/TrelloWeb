package com.example.trelloweb.user.signup.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupForm {
    @NotEmpty(message = "이메일을 확인해주세요")
    private String EMAIL;

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String pw;

    @NotEmpty(message = "비밀번호를 확인해주세요")
    private String pwcheck;

    @NotEmpty(message = "이름을 입력해주세요")
    private String fullname;

    @NotEmpty(message = "닉네임을 입력해주세요")
    private String nickname;

    private String BIRTH;

    @Size(max = 500, message = "자기소개는 500자 이하입니다")
    private String BIO;
}
