package com.example.trelloweb.user.login_API.loginVo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serial;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser implements UserDetails, OAuth2User{

    @Serial
    private static final long serialVersionUID = 5216516135213203541L;

    @NotNull private String UID;

    @NotNull private String PW;

    @NotNull private String AuthProvider;

    private Map<String,Object> attributes;

    private List<GrantedAuthority> authorities;

    public Object getAttribute(String name){
        return attributes.get(name);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return this.UID;
    }

    @Override
    public String getPassword() {
        return PW;
    }

    @Override
    public String getUsername() {
        return this.UID;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
