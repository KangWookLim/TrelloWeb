package com.example.trelloweb.card.mem.repo;

import com.example.trelloweb.card.mem.vo.CardMembers;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CardMemberRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<CardMembers> rmMembers =(rs, rowNum) ->
            new CardMembers(
                    rs.getLong("card_id"),
                    rs.getString("user_uid")
            );

    public List<CardMembers> getCardMember(Long cardId) {
        String sql = "SELECT * FROM CARD_MEMBERS WHERE CARD_ID = :card_id";
        Map<String, Long> params = Map.of("card_id",cardId);
        return jdbcTemplate.query(sql, params, rmMembers);
    }
}
