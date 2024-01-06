//package com.example.trelloweb.boarddetail.repo;
//
//import com.example.trelloweb.boarddetail.vo.BoardDetailVo;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.util.List;
//
//@Repository
//public class BoardDetailRepo {
//    NamedParameterJdbcTemplate jdbcTemplate;
//    RowMapper<BoardDetailVo> rowMapper = (rs, rowNum) ->
//            new BoardDetailVo(
//                    rs.getString("board_id"),
//                    rs.getString("ws_id"),
//                    rs.getString("name"),
//                    rs.getString("image_url"),
//                    rs.getString("description"),
//                    rs.getString("template_id")
//            );
//    protected List<BoardDetailVo> getAllBoard(){
//        String sql = "select * from board";
//        return jdbcTemplate.query(sql,rowMapper);
//    }
//}
