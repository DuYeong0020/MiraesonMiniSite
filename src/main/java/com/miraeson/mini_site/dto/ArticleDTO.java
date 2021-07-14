package com.miraeson.mini_site.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;

@Getter @Data
public class ArticleDTO {

    private Long id;
    private String username;
    private Integer board;
    private String title;

    private String content;
    private Timestamp created_time;
    private Timestamp updated_time;
    private Long view;

    @QueryProjection
    public ArticleDTO(Long id, String username, Integer board, String title, String content, Timestamp created_time, Timestamp updated_time, Long view) {
        this.id = id;
        this.username = username;
        this.board = board;
        this.title = title;
        this.content = content;
        this.created_time = created_time;
        this.updated_time = updated_time;
        this.view = view;
    }
}
