package com.miraeson.mini_site.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.function.ToDoubleBiFunction;

@Getter @AllArgsConstructor @NoArgsConstructor
@Entity  @Table
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @JoinColumn(name="user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonBackReference
    @JoinColumn(name="article_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @Lob
    private String content;

    private Timestamp created_time = new Timestamp(System.currentTimeMillis());

    public Comment(User user, Article article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
