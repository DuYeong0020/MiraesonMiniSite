package com.miraeson.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity @Table(name = "articletest")
@Getter @AllArgsConstructor @NoArgsConstructor
public class Article {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bulletinBoardId; //게시글 아이디
    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private Long views; // 조회수

    private String date; // 작성한 날짜


}
