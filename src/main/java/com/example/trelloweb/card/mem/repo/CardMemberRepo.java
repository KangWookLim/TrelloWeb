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
                    rs.getString("user_uid"),
                    rs.getString("nickname")
            );

    public List<CardMembers> getCardMember(Long cardId) {
        String sql = "SELECT cm.*, u.nickname\n" +
                "FROM card_members cm\n" +
                "JOIN users u ON cm.user_uid = u.user_uid\n" +
                "WHERE cm.card_id = :card_id";
        Map<String, Long> params = Map.of("card_id",cardId);
        return jdbcTemplate.query(sql, params, rmMembers);
    }
}
