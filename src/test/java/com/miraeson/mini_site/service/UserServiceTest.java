package com.miraeson.mini_site.service;

import com.miraeson.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    @DisplayName("회원가입하기") @Transactional
    public void signIn() throws Exception {
        // given
        User user = new User("sun", "avatar", "dudu@naver.com");
        // when
        User newUser = userService.createUser(user);
        // then
        Assertions.assertEquals(user, newUser);
    }



}