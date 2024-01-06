package com.example.trelloweb.signup.repo;


import com.example.trelloweb.signup.vo.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SignupRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    RowMapper<Users> rm1 = (rs, rowNum) ->
            new Users(
                    rs.getInt("User_UID"),
                    rs.getString("ID"),
                    rs.getString("PW"),
                    rs.getString("IMG"),
                    rs.getString("NICKNAME"),
                    rs.getString("FULLNAME"),
                    rs.getString("EMAIL"),
                    rs.getString("BIRTH"),
                    rs.getString("GENDER").charAt(0),
                    rs.getString("PHONE"),
                    rs.getString("CREATE_DATE"),
                    rs.getString("BIO"),
                    rs.getString("Social_LINK_1"),
                    rs.getString("Social_LINK_2"),
                    rs.getString("Social_LINK_3"),
                    rs.getString("Social_LINK_4")
            );


}
