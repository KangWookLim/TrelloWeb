package com.example.trelloweb.card.tasklist.item.repo;

import com.example.trelloweb.card.tasklist.item.vo.TaskItems;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class TaskItemRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<TaskItems> rowMapper = (rs, rowNum) ->
            new TaskItems(
                    rs.getBoolean("is_checked"),
                    rs.getLong("task_id"),
                    rs.getLong("task_item_id"),
                    rs.getString("title")
            );
    public List<TaskItems> getTaskItems(Long taskid) {
        String sql = "SELECT * FROM TASK_ITEM WHERE task_id = :taskid";
        Map<String, Long> params = Map.of("taskid",taskid);
        return jdbcTemplate.query(sql, params, rowMapper);
    }

    public Integer getPercentage(Long taskId) {
        String sql = "SELECT " +
                "   COUNT(CASE WHEN is_checked = true THEN 1 END) * 100.0 / NULLIF(COUNT(*), 0) AS percentage_true " +
                "FROM " +
                "   task_item " +
                "WHERE " +
                "   task_id = :taskid";

        Map<String, Long> params = Map.of("taskid", taskId);

        // queryForObject 대신 query 메서드를 사용하고, 반환 타입을 Integer로 지정

        return jdbcTemplate.query(sql, params, rs -> {
            if (rs.next()) {
                // 결과가 있을 때는 결과를 가져오고
                return rs.getInt("percentage_true");
            } else {
                // 결과가 없을 때는 원하는 기본값이나 특별한 값 반환
                return 0; // 또는 원하는 기본값
            }
        });
    }
}
