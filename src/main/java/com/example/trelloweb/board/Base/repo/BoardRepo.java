package com.example.trelloweb.board.Base.repo;

import com.example.trelloweb.board.Base.vo.Boards;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BoardRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Boards> rowMapper = (rs, rowNum) ->
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


    public List<Boards> getAllBoardInfo(String memId) {
        String query =
    "WITH\n" +
    "   USER_WS AS(\n" +
    "       SELECT *\n" +
    "       FROM ws_members\n" +
    "       WHERE user_uid = :memId\n" +
    "   ),\n" +
    "   MEM_WS AS (\n" +
    "       SELECT WS2.*, WS1.ROLE\n" +
    "       FROM USER_WS WS1\n" +
    "       LEFT OUTER JOIN WORKSPACE WS2\n" +
    "       ON WS1.WS_ID = WS2.WS_ID\n" +
    "       ORDER BY WS2.CREATED_DATE DESC\n" +
    "   ),\n" +
    "   USER_BOARD AS(\n" +
    "       SELECT *\n" +
    "       FROM BOARD_MEMBER\n" +
    "       WHERE USER_UID = :memId\n" +
    "   ),\n" +
    "   MEM_BOARD AS(\n" +
    "       SELECT B2.*, B1.BOARD_ACCESS\n" +
    "       FROM USER_BOARD B1\n" +
    "       LEFT OUTER JOIN BOARD B2\n" +
    "       ON B1.BOARD_ID = B2.BOARD_ID\n" +
    "   )\n" +
    "SELECT T1.WS_ID WS_ID, NAME WS_NAME, IMG_URL WS_IMG, ROLE WS_ROLE, CREATED_DATE WS_DATE, BOARD_ID, BOARD_NAME, IMAGE_URL BOARD_IMG, DESCRIPTION BOARD_DES, BOARD_ACCESS\n" +
    "FROM MEM_BOARD T1\n" +
    "LEFT OUTER JOIN MEM_WS T2\n" +
    "ON T1.WS_ID = T2.WS_ID;";
        Map<String, Object> param = Map.of("memId", memId);
        return jdbcTemplate.query(query, param, rowMapper);
    }
}
