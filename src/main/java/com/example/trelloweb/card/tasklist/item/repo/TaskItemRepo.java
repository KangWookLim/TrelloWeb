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
}
