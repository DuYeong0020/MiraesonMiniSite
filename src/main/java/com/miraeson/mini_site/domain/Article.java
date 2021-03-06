package com.miraeson.mini_site.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity @Table
@Getter @AllArgsConstructor @NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //게시글 아이디, PK


    @JsonBackReference
    @JoinColumn(name="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();


    private Integer board = 100; // 게시판 종류(100: 자유게시판)

    private String title = ""; // 게시글 제목

    @Lob
    private String content; // 게시글 본문 내용

    private Timestamp created_time = new Timestamp(System.currentTimeMillis()); // 게시글 생성일

    private Timestamp updated_time = new Timestamp(System.currentTimeMillis()); // 게시글 수정일

    private Long views = 0L; // 게시글 조회수

    private Integer deleted = 0; // 게시글 삭제 여부(0:삭제안함, 1:삭제)

    public Article(Long id, Integer board, String title, String content) {
        this.id = id;
        this.board = board;
        this.title = title;
        this.content = content;
    }

    public Article(Integer board, String title, String content) {
        this.board = board;
        this.title = title;
        this.content = content;
    }
    public Article(String title, String content,Long id) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article(Long id, User user, Integer board, String title, String content, Timestamp created_time, Timestamp updated_time, Long views, Integer deleted) {
        this.id = id;
        this.user = user;
        this.board = board;
        this.title = title;
        this.content = content;
        this.created_time = created_time;
        this.updated_time = updated_time;
        this.views = views;
        this.deleted = deleted;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
