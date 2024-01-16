/* 제가 말씀드린 내용은 JDBC상에서 이용할 때 사용할 "VO"를 만들어 사용하면 좋다는 말이었습니다
* 아래 하신 작업은 Boards라는 테이블을 만드는 코드입니다
* 같은 기능을 가진 복수 테이블이 있는건 좋지않습니다
* 필요나 기능에 따라 VO만드실때 Entitiy는 사용하지 말아주십쇼 JPA 구동되면서 테이블 생성됩니다,
* 추가로 @Id 는 PK설정입니다 복합으로 사용하실 경우 복합키 전용 클래스 @Idclass를 이용해
* 복합키를 위한 클래스를 같이 생성해서 적용해 주어야합니다** 예시는 Board_memVo를 확인하시면 됩니다. */

//package com.example.trelloweb.board.Base.vo;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Boards {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer USER_UID;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer WS_ID;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer BOARD_ID;
//
//    @Column(length = 50)
//    private String WS_role;
//
//    @Column(length = 100)
//    private String WS_created_date;
//
//    @Column(length = 100)
//    private String WS_IMG_URL;
//
//    @Column(length = 100)
//    private String WS_NAME;
//
//    @Column(length = 100)
//    private String Board_NAME;
//
//    @Column(length = 100)
//    private String Board_Access;
//
//    @Column(length = 100)
//    private String Board_Description;
//
//    @Column(length = 100)
//    private String Board_Image_url;
//
//
//
//
//}
