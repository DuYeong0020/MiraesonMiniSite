package com.miraeson.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Table(name = "usertest")
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 아이디, PK

    @OneToMany(mappedBy = "user")
    private List<Article> articles = new ArrayList<>();


    private String username; // 회원 닉네임

    private String avatar; // 회원 아바타 이미지 링크

    private String email; // 회원 이메일
    private Integer social_type; // 소셜 가입 종류(100:없음, 200:구글)


    private Timestamp created_time; // 계정 생성일

    private Integer admin; // 운영자 여부(0:일반 회원, 1:운영자)

    private Integer withdraw; // 계정 탈퇴 여부(0:탈퇴 안함, 1:탈퇴)
    private Timestamp withdraw_time; // 계정 탈퇴일
    private String memo; // 관리자용 메모

    public User(Long id, String username, Timestamp created_time, Integer admin, Integer withdraw) {
        this.id = id;
        this.username = username;
        this.created_time = created_time;
        this.admin = admin;
        this.withdraw = withdraw;
    }

    public User(String username, String avatar, String email) {
        this.username = username;
        this.avatar = avatar;
        this.email = email;
    }

    public User(String username, String avatar, String email, Integer social_type, Timestamp created_time, Integer admin, Integer withdraw, Timestamp withdraw_time, String memo) {
        this.username = username;
        this.avatar = avatar;
        this.email = email;
        this.social_type = social_type;
        this.created_time = created_time;
        this.admin = admin;
        this.withdraw = withdraw;
        this.withdraw_time = withdraw_time;
        this.memo = memo;
    }
}
