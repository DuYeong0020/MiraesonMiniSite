package com.miraeson.mini_site.repository;

import com.miraeson.mini_site.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMySqlRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test @Transactional
    @DisplayName("가입 안되어있을 때 회원가입하기")
    public void save() throws Exception {
        // given
        User user = new User("sun", "avatar", "dudu@naver.com", 200);
        // when
        Long saveUser = userRepository.save(user); // db에 저장한다.

        User findUser = userRepository.findById(saveUser); // 유저를 찾아온다.
        // then

        assertEquals(user.getUsername(), findUser.getUsername());

    }

}