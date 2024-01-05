package com.example.trelloweb.signup.vo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails{

    private Integer USER_UID;
    private String ID;
    private String PW;
    private String IMG;
    private String NICKNAME;
    private String FULLNAME;
    private String EMAIL;
    private String BIRTH;
    private Character GENDER;
    private String PHONE;
    private String CREATE_DATE;
    private String BIO;
    private String SOCIAL_LINK_1;
    private String SOCIAL_LINK_2;
    private String SOCIAL_LINK_3;
    private String SOCIAL_LINK_4;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
