package com.example.trelloweb.card.comment.repo;

import com.example.trelloweb.card.comment.vo.CardComments;
import com.example.trelloweb.card.label.vo.CardLabels;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CardCommentRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<CardComments> rowMapper =(rs, rowNum) ->
            new CardComments(
                    rs.getLong("card_comment_id"),
                    rs.getLong("card_id"),
                    rs.getString("created_date"),
                    rs.getString("comment"),
                    rs.getString("user_uid"),
                    rs.getString("nickname")
            );



    public List<CardComments> getComments(Long cardId){
        String sql = "SELECT CARD_COMMENT.*, USERS.nickname\n" +
                "FROM CARD_COMMENT\n" +
                "JOIN USERS ON CARD_COMMENT.user_uid = USERS.user_uid\n" +
                "WHERE CARD_COMMENT.card_id = :card_id";
        Map<String, Long> params = Map.of("card_id",cardId);
        return jdbcTemplate.query(sql, params, rowMapper);
    }
}
