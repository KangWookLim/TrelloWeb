package com.example.trelloweb.card.base.repo;

import com.example.trelloweb.card.attatchments.vo.CardAttachments;
import com.example.trelloweb.card.base.vo.CardVo;
import com.example.trelloweb.card.base.vo.Cards;
import com.example.trelloweb.card.mem.vo.CardMembers;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
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



}
