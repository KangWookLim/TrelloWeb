package com.example.trelloweb.user.oauthLogin.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class OAuth2SignForm {
    @NotEmpty(message = "닉네임을 입력해주세요")
    private String nickname;

    private String PW;

    private String PWCK;

    private String Birth;
}
