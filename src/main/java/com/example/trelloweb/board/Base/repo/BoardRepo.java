package com.example.trelloweb.board.Base.repo;

import com.example.trelloweb.board.Base.vo.Boards;
import com.example.trelloweb.board.Base.vo.WorkSpaces;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BoardRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    RowMapper<Boards> rowMapper = (rs, rowNum) ->
            new Boards(
                    rs.getInt("WS_ID"),
                    rs.getString("WS_NAME"),
                    rs.getString("WS_IMG"),
                    rs.getString("WS_ROLE"),
                    rs.getString("WS_DATE"),
                    rs.getInt("BOARD_ID"),
                    rs.getString("BOARD_NAME"),
                    rs.getString("BOARD_IMG"),
                    rs.getString("BOARD_DES"),
                    rs.getString("BOARD_ACCESS")
            );
    RowMapper<WorkSpaces> WSrowMapper = (rs, rowNum) ->
            new WorkSpaces(
                    rs.getInt("WS_ID"),
                    rs.getString("NAME"),
                    rs.getString("IMG_URL"),
                    rs.getString("ROLE"),
                    rs.getString("CREATED_DATE")
            );



    public List<Boards> getAllBoardInfo(String memId)
    {
        String query = " WITH USER_WS AS(SELECT * FROM ws_members WHERE USER_UID = "+ memId +" ), MEM_WS AS (SELECT WS2.*, WS1.ROLE FROM USER_WS WS1 LEFT OUTER JOIN WORKSPACE WS2 ON WS1.WS_ID = WS2.WS_ID ORDER BY WS2.CREATED_DATE DESC),USER_BOARD AS(SELECT * FROM BOARD_MEMBER WHERE USER_UID = "+memId+"),MEM_BOARD AS(SELECT B2.*, B1.BOARD_ACCESS FROM USER_BOARD B1 LEFT OUTER JOIN BOARD B2 ON B1.BOARD_ID = B2.BOARD_ID)SELECT T1.WS_ID WS_ID, NAME WS_NAME, IMG_URL WS_IMG, ROLE WS_ROLE, CREATED_DATE WS_DATE, BOARD_ID, BOARD_NAME, IMAGE_URL BOARD_IMG, DESCRIPTION BOARD_DES, BOARD_ACCESS FROM MEM_BOARD T1 LEFT OUTER JOIN MEM_WS T2 ON T1.WS_ID = T2.WS_ID";
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<WorkSpaces> getAllWSInfo(String memId)
    {
        String query = "SELECT T1.WS_ID WS_ID, NAME, IMG_URL, ROLE, CREATED_DATE FROM WORKSPACE T2 LEFT OUTER JOIN WS_MEMBERS T1 ON T2.WS_ID = T1.WS_ID WHERE T1.USER_UID = "+ memId;
        return jdbcTemplate.query(query, WSrowMapper);
    }
}
