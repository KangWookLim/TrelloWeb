package com.example.trelloweb.user.login_API.Role;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");
    UserRole(String val){
        this.value = val;
    }
    private String value;
}
