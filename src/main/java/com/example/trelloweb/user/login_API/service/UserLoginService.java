package com.example.trelloweb.user.login_API.service;

import com.example.trelloweb.user.base.repo.UserJpaRepo;
import com.example.trelloweb.user.base.vo.UserVo;
import com.example.trelloweb.user.Role.UserRole;
import com.example.trelloweb.user.login_API.loginVo.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserLoginService implements UserDetailsService {





    private final UserJpaRepo userJpaRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserVo> optionalUserVo = this.userJpaRepo.findByEMAIL(username);
        if(optionalUserVo.isEmpty()){
            throw  new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        UserVo userVo = optionalUserVo.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return AuthUser.builder()
                .UID(String.valueOf(userVo.getUser_uid()))
                .PW(userVo.getPW())
                .IMG_URL(userVo.getIMG_URL())
                .authorities(authorities)
                .build();
    }
}
