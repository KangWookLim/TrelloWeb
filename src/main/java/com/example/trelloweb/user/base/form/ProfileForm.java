package com.example.trelloweb.user.base.form;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileForm {
    private String FullName;
    private String NickName;
    private String BIO;
    private String SOCIALLINK1;
    private String SOCIALLINK2;
    private String SOCIALLINK3;
    private String SOCIALLINK4;
}
