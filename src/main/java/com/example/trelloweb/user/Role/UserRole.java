package com.example.trelloweb.user.Role;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");
    UserRole(String val){
        this.value = val;
    }
    private final String value;
}
