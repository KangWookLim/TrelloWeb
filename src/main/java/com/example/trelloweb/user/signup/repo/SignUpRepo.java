package com.example.trelloweb.user.signup.repo;

import com.example.trelloweb.user.signup.vo.SignupVo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SignUpRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<SignupVo> rowMapper = ((rs, rowNum) ->
            new SignupVo(
                    rs.getString("id"),
                    rs.getString("nickname"),
                    rs.getString("phone")
            ));

    public int nickduplicatCheck(String nick){
        String sql = "select count(*) from users where nickname = :nick";
        Map<String,String> params = Map.of("nick", nick);
        try{
            return jdbcTemplate.queryForObject(sql, params, int.class);
        }catch (NullPointerException e){
            return 0;
        }
    }

    public int checkEmail(String email) {
        String sql = "select count(*) from users where EMAIL = :email";
        Map<String,String> params = Map.of("email",email);
        try{
            return jdbcTemplate.queryForObject(sql, params, int.class);
        }catch (NullPointerException e){
            return 0;
        }
    }
}
