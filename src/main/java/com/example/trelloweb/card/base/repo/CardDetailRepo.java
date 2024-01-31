package com.example.trelloweb.card.base.repo;

import com.example.trelloweb.card.base.vo.Cards;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CardDetailRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Cards> rowMapper =(rs, rowNum) ->
            new Cards(
                    rs.getInt("card_order"),
                    rs.getLong("cardid"),
                    rs.getString("created_date"),
                    rs.getString("updated_date"),
                    rs.getString("due_date"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("cover")
            );
    public Cards getCardByCardId(Long cardId) {

        String sql = "SELECT * FROM card WHERE cardId = :cardId";
        Map<String,Long> params = Map.of("cardId", cardId);
        return jdbcTemplate.queryForObject(sql, params ,rowMapper);
    }


    public int updateDueDate(Long cardId, String dueDate) {
        String sql = "UPDATE card SET due_date = :dueDate WHERE cardId = :cardId";
        Map<String,Object> params = Map.of("cardId", cardId, "dueDate", dueDate);
        return jdbcTemplate.update(sql, params);
    }

    public int removeDueDate(Long cardId) {
        String sql = "UPDATE card SET due_date = NULL WHERE cardId = :cardId";
        Map<String,Long> params = Map.of("cardId", cardId);
        return jdbcTemplate.update(sql, params);
    }
}
