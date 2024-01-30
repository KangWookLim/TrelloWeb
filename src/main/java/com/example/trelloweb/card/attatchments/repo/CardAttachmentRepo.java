package com.example.trelloweb.card.attatchments.repo;

import com.example.trelloweb.card.attatchments.vo.CardAttachments;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CardAttachmentRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<CardAttachments> rowMapper =(rs, rowNum) ->
            new CardAttachments(
                    rs.getString("added_date"),
                    rs.getLong("att_board_id"),
                    rs.getLong("att_id"),
                    rs.getLong("card_id"),
                    rs.getString("origin_file_name"),
                    rs.getString("stored_file_name")
            );
    public List<CardAttachments> getAttachments(Long cardId){
        String sql = "SELECT * FROM CARD_ATTATCHMENTS where card_id = :cardid";
        Map<String, Long> params = Map.of("cardid",cardId);
        return jdbcTemplate.query(sql, params, rowMapper);
    }
}
