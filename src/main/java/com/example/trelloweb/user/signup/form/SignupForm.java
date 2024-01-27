package com.example.trelloweb.user.signup.form;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "아이디를 입력해주세요")
    private String ID;

    @NotBlank(message = "이메일을 입력해주세요")
//    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다")
    private String EMAIL;

    @NotBlank(message = "비밀번호를 입력해주세요")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$", message = "영어, 숫자, 특수문자(@$!%*#?&)를 포함한 8~16자입니다")
    private String pw;

    @NotBlank(message = "비밀번호를 확인해주세요")
    private String pwcheck;

    @NotBlank(message = "이름을 입력해주세요")
//    @Pattern(regexp = "^\\D*$", message = "이름에 숫자가 들어갈 수 없습니다")
    private String fullname;

    @NotBlank(message = "닉네임을 입력해주세요")
//    @Pattern(regexp = "^[a-zA-Z0-9가-힣]+$", message = "닉네임에 특수문자가 들어갈 수 없습니다")
    private String nickname;

    @NotBlank(message = "생년월일을 선택해주세요")
    private String BIRTH;

    @Size(max = 500, message = "자기소개는 500자 이하입니다")
    private String BIO;
}
