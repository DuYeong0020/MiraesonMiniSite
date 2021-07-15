package com.miraeson.mini_site.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;

@Getter @Data
public class CommentDTO {

    private Long id;
    private Long article_id;
    private Long user_id;
    private String content;
    private Timestamp created_time;
    private String username;

    @QueryProjection
    public CommentDTO(Long id, Long article_id, Long user_id, String content, Timestamp created_time, String username) {
        this.id = id;
        this.article_id = article_id;
        this.user_id = user_id;
        this.content = content;
        this.created_time = created_time;
        this.username = username;
    }
}
