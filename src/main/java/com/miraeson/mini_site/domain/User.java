package com.miraeson.mini_site.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Table
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 아이디, PK

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>();


    private String username ="익명"; // 회원 닉네임

    private String avatar; // 회원 아바타 이미지 링크

    private String email; // 회원 이메일
    private Integer social_type = 100; // 소셜 가입 종류(100:없음, 200:구글)

    private Timestamp created_time =  new Timestamp(System.currentTimeMillis()); // 계정 생성일

    private Integer admin = 0; // 운영자 여부(0:일반 회원, 1:운영자)

    private Integer withdraw = 0; // 계정 탈퇴 여부(0:탈퇴 안함, 1:탈퇴)
    private Timestamp withdraw_time; // 계정 탈퇴일
    private String memo; // 관리자용 메모

    public User(String username, String avatar, String email, Integer social_type) {
        this.social_type = social_type;
        this.username = username;
        this.avatar = avatar;
        this.email = email;
    }
    public User(String username, String avatar, String email) {
        this.username = username;
        this.avatar = avatar;
        this.email = email;
    }

    public void setSocial_type(Integer social_type) {
        this.social_type = social_type;
    }

}
