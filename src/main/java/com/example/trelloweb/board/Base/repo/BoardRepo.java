//package com.example.trelloweb.board.Base.repo;
//
//import com.example.trelloweb.board.Base.vo.BoardVo;
//import com.example.trelloweb.board.board_mem.vo.Board_memVo;
//import com.example.trelloweb.list.vo.ListVo;
//import com.example.trelloweb.workspace.Base.vo.WorkSpaceVo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class BoardRepo {
//
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//    private RowMapper<BoardVo> rowMapper = ((rs, rowNum) ->
//            new BoardVo(
//                    rs.getLong("BoardId"),
//                    (WorkSpaceVo) rs.getObject("WS_ID"),
//                    rs.getString("BoardName"),
//                    rs.getString("image_URL"),
//                    rs.getString("description"),
//            ));
//}
