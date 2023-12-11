package com.example.trelloweb.signup.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Signuptoken {
    String token;
    String email;
    String expirationtime;
    String isused;
}
