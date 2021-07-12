package com.miraeson.mini_site.repository;


import com.miraeson.domain.User;

import java.util.List;

public interface UserRepository {
    // 회원 저장
    Long save(User user);
    // 이름으로 회원 조회
    List<User> findByName(String name);

    // 아이디로 회원 조회
    User findById(Long id);
}
