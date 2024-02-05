package com.example.trelloweb.user.base.form;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileForm {
    private String FullName;
    @Size(max = 500, message = "자기소개는 500자 이하입니다")
    private String BIO;
    private String BIRTH;
    private String SOCIALLINK1;
    private String SOCIALLINK2;
    private String SOCIALLINK3;
    private String SOCIALLINK4;
}
