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

    public int addCover(Long cardId, String cover) {
        String sql = "Update card SET cover = :cover WHERE cardId = :card_Id";
        Map<String, Object> params = Map.of( "cover", cover,"card_Id", cardId);
        return jdbcTemplate.update(sql,params);
    }

    public int removeCover(Long cardId) {
        String sql = "Update card SET cover = null WHERE cardId = :card_Id";
        Map<String, Long> params = Map.of("card_Id", cardId);
        return jdbcTemplate.update(sql,params);
    }

    public int description(String description, Long cardId) {
        String sql = "Update card SET description = :description WHERE cardId = :card_Id";
        Map<String, Object> params = Map.of( "description", description,"card_Id", cardId);
        return jdbcTemplate.update(sql,params);
    }

    public int getOrderMax(Long listId) {
        String sql = "Select max(card_order) from card where list_id = :listId";
        Map<String, Long> params = Map.of("listId",listId);
        try{
            return jdbcTemplate.queryForObject(sql, params, int.class);
        }catch (NullPointerException e){
            return 0;
        }
    }
}
