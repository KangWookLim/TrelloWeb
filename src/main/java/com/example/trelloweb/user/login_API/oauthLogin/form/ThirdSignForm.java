package com.example.trelloweb.user.login_API.oauthLogin.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThirdSignForm {

    @NotBlank(message = "닉네임을 입력해주세요")
//    @Pattern(regexp = "^[a-zA-Z0-9가-힣]+$", message = "닉네임에 특수문자가 들어갈 수 없습니다")
    private String nickname;

    @NotBlank(message = "비밀번호를 입력해주세요")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$", message = "비밀번호 형식이 올바르지 않습니다 /n 형식은 영어, 숫자, 특수문자(@$!%*#?&)를 전부 포함한 8~16자입니다")
    private String PW;

    @NotBlank(message = "비밀번호를 확인해주세요")
    private String PWCK;

    @NotBlank(message = "생년월일을 선택해주세요")
    private String Birth;
}
