package com.example.trelloweb.card.tasklist.base.repo;

import com.example.trelloweb.card.tasklist.base.vo.CardTasks;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CardTaskRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<CardTasks> rowMapper = (rs,rowNum) ->
            new CardTasks(
                    rs.getLong("card_id"),
                    rs.getString("createddate"),
                    rs.getLong("task_id"),
                    rs.getString("title")
            );

    public List<CardTasks> getAllTasks(Long cardid) {
        String sql = "SELECT * FROM CARD_TASK WHERE CARD_ID = :cardid";
        Map<String, Long> params = Map.of("cardid",cardid);
        return jdbcTemplate.query(sql, params, rowMapper);
    }
}
