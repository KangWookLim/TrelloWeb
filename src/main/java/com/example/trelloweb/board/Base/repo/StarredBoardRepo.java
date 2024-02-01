package com.example.trelloweb.board.Base.repo;

import com.example.trelloweb.board.Base.vo.Boards;
import com.example.trelloweb.board.Base.vo.StarredBoards;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StarredBoardRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    RowMapper<StarredBoards> rowMapper = (rs, rowNum) ->
            new StarredBoards(
                    rs.getInt("WS_ID"),
                    rs.getString("WS_NAME"),
                    rs.getInt("BOARD_ID"),
                    rs.getString("BOARD_NAME"),
                    rs.getString("BOARD_IMG")
            );
    public List<StarredBoards> getAllStarredBoardInfo(String memId) {
        String query = "SELECT T1.WS_ID WS_ID, T2.NAME WS_NAME, BOARD_ID, BOARD_NAME, T1.IMAGE_URL BOARD_IMG\n" +
                "FROM (\n" +
                "SELECT BOARD_ID, BOARD_NAME, IMAGE_URL,WS_ID\n" +
                "FROM BOARD\n" +
                "RIGHT OUTER JOIN\n" +
                "(SELECT STARRED_BOARD_ID\n" +
                "FROM USER_STARRED_BOARD\n" +
                "WHERE USER_UID = '"+ memId +"' )\n" +
                "ON BOARD_ID = STARRED_BOARD_ID) T1\n" +
                "LEFT OUTER JOIN WORKSPACE T2\n" +
                "ON T1.WS_ID = T2.WS_ID";
        return jdbcTemplate.query(query, rowMapper);
    }
    public int checkStarredBoard(String boardId, String memId) {
        String query = "SELECT COUNT(*)\n" +
                "FROM USER_STARRED_BOARD\n" +
                "WHERE USER_UID = '"+ memId+"' AND STARRED_BOARD_ID = :boardId";
        SqlParameterSource namedParameters = new MapSqlParameterSource("boardId",boardId);
        return this.jdbcTemplate.queryForObject(query, namedParameters, Integer.class);
    }
    public void deleteStarredBoard(String boardId, String memId) {
        String query = "DELETE FROM USER_STARRED_BOARD WHERE STARRED_BOARD_ID = :boardId AND USER_UID = '"+ memId  + "'";
        Map<String, Object> params = Map.of("boardId", boardId);
        jdbcTemplate.update(query, params);
    }
    public void createStarredBoard(String boardId, String memId) {
        String query = "INSERT INTO USER_STARRED_BOARD VALUES ( :boardId, '"+ memId + "')";
        Map<String, Object> params = Map.of("boardId", boardId);
        jdbcTemplate.update(query, params);
    }


}

