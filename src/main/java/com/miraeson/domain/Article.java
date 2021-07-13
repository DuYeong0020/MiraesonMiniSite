package com.miraeson.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity @Table
@Getter @AllArgsConstructor @NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //게시글 아이디, PK


    @ManyToOne(fetch = FetchType.LAZY) @NotNull
    @JoinColumn(name="user_id")
    private User user;



    private Integer board; // 게시판 종류(100: 자유게시판)

    private String title; // 게시글 제목

    @Lob
    private String content; // 게시글 본문 내용

    private Timestamp created_time; // 게시글 생성일

    private Timestamp updated_time; // 게시글 수정일

    private Long views; // 게시글 조회수

    private Integer deleted; // 게시글 삭제 여부(0:삭제안함, 1:삭제)

    public Article(User user, Integer board, String title, String content, Timestamp created_time, Timestamp updated_time, Long views, Integer deleted) {
        this.user = user;
        this.board = board;
        this.title = title;
        this.content = content;
        this.created_time = created_time;
        this.updated_time = updated_time;
        this.views = views;
        this.deleted = deleted;
    }
}
