/*
* 구상은 정말 잘하셨습니다 JPA를 처음 쓰셔서 조금 아쉬운 부분이었습니다
* 만약 JPA와 Mapper혹은 JDBC를 결합해 사용하신다면 JPAVO와 Mapper혹은 JDBC를 사용해 DB에서
* 꺼내온 데이터를 담아낼 Vo는 서로 성격과 하는 역할이 비슷하만 다릅니다
* 가장 큰 차이점은 JPAVo의 경우 @Entity어노테이션이 들어가고 @Id어노테이션이 적용 된
* 필드가 요구됩니다. 이 부분 확실하게 이해하고 넘어가시면 좋습니다.
* 테이블이나 쿼리문에서 데이터를 그져 꺼내올 목적으로 사용하는 Vo의 경우 단순하게
* 쿼리문을 실행했을때 리턴되는 칼럼명과 개수, 자료형에 맞게 구성된 Vo를 만들어 주시면 됩니다.  */

//package com.example.trelloweb.board.Base.repo;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//
//@Repository
//@RequiredArgsConstructor
//public class BoardRepo {
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//    private final RowMapper<Boards> rowMapper = (rs, rowNum) ->
//            new Boards(
//                    rs.getInt("user_uid"),
//                    rs.getInt("WS_id"),
//                    rs.getInt("Board_id"),
//                    rs.getString("WS_role"),
//                    rs.getString("WS_created_date"),
//                    rs.getString("WS_img_url"),
//                    rs.getString("WS_name"),
//                    rs.getString("Board_name"),
//                    rs.getString("Board_access"),
//                    rs.getString("Board_description"),
//                    rs.getString("Board_image_url")
//            );
//
//
//    public List<Boards> getAllBoardInfo(String memId) {
//        String query =
//                " WITH\n" +
//                    "USER_WS AS(\n" +
//                    "    SELECT *\n" +
//                    "    FROM ws_members\n" +
//                    "    WHERE user_uid = :memId\n" +
//                    "),\n" +
//                    "MEM_WS AS (\n" +
//                    "    SELECT WS2.*, WS1.ROLE, WS1.USER_UID\n" +
//                    "    FROM USER_WS WS1\n" +
//                    "    LEFT OUTER JOIN WORKSPACE WS2\n" +
//                    "    ON WS1.WS_ID = WS2.WS_ID\n" +
//                    "    ORDER BY WS2.CREATED_DATE DESC\n" +
//                    "),\n" +
//                    "USER_BOARD AS(\n" +
//                    "    SELECT *\n" +
//                    "    FROM BOARD_MEMBER\n" +
//                    "    WHERE USER_UID = :memId\n" +
//                    "),\n" +
//                    "MEM_BOARD AS(\n" +
//                    "    SELECT B2.*, B1.BOARD_ACCESS, B1.USER_UID\n" +
//                    "    FROM USER_BOARD B1\n" +
//                    "    LEFT OUTER JOIN BOARD B2\n" +
//                    "    ON B1.BOARD_ID = B2.BOARD_ID\n" +
//                ")\n" +
//                "SELECT *\n" +
//                "FROM MEM_BOARD T1\n" +
//                "LEFT OUTER JOIN MEM_WS T2\n" +
//                "ON T1.WS_ID = T2.WS_ID";
//        Map<String, Object> param = Map.of("memId", memId);
//        return jdbcTemplate.query(query, param, rowMapper);
//    }
//}
