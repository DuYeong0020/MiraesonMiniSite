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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;



    private Integer board = 100; // 게시판 종류(100: 자유게시판)

    private String title = ""; // 게시글 제목

    @Lob
    private String content; // 게시글 본문 내용

    private Timestamp created_time = new Timestamp(System.currentTimeMillis()); // 게시글 생성일

    private Timestamp updated_time = new Timestamp(System.currentTimeMillis()); // 게시글 수정일

    private Long views = 0L; // 게시글 조회수

    private Integer deleted = 0; // 게시글 삭제 여부(0:삭제안함, 1:삭제)

    public Article(Long id, User user, Integer board, String title, String content) {
        this.id = id;
        this.user = user;
        this.board = board;
        this.title = title;
        this.content = content;
    }
}
