package com.example.trelloweb.card.label.repo;

import com.example.trelloweb.card.label.vo.CardLabels;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CardLabelRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<CardLabels> rowMapper =(rs, rowNum) ->
            new CardLabels(
                    rs.getLong("card_id"),
                    rs.getLong("label_id"),
                    rs.getString("color"),
                    rs.getString("title")
            );
    public List<CardLabels> getLabels(Long cardId){
        String sql = "SELECT * FROM CARD_LABELS where card_id = :cardid";
        Map<String, Long> params = Map.of("card_id",cardId);
        return jdbcTemplate.query(sql, params, rowMapper);
    }
}
