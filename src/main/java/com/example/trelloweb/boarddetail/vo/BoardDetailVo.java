package com.example.trelloweb.boarddetail.vo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardDetailVo {
    private String board_id;

    private String ws_id;

    private String name;

    private String image_url;

    private String description;

    private String template_id;
}
