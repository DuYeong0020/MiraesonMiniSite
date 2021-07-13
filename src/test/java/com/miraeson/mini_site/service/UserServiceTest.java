package com.miraeson.mini_site.service;

import com.miraeson.domain.User;
import com.miraeson.mini_site.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("구글 회원가입하기") @Transactional
    public void googleSignIn() throws Exception {
        // given
        User user = new User("sun", "avatar", "dudu@naver.com", 200, 0, 0);

        // when
        User newUser = userService.createUser(user);

        // then
        Assertions.assertEquals(user.getUsername(), newUser.getUsername()); // 나중에 클래스를 비교하는 걸로 수정
    }



}