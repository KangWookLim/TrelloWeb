package com.example.trelloweb.user.Role;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");
    UserRole(String val){
        this.value = val;
    }
    private String value;
}
