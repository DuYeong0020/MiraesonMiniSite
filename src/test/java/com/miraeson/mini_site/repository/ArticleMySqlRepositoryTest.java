package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;
import com.miraeson.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest @ExtendWith(SpringExtension.class) @Transactional
class ArticleMySqlRepositoryTest {

    @Autowired ArticleRepository articleRepository;
    @Autowired UserRepository userRepository;

//    @Test
//    @DisplayName("게시글 작성")
//    public void saveArticle() throws Exception {
//        // given
//        // 로그인 or 회원가입
//        User user = new User("sun", "avatar", "dudu@naver.com", 200);
//        Long saveUser = userRepository.save(user);
//        User findUser = userRepository.findById(saveUser);
//        Article article = new Article(findUser.getId(), findUser, 100, "hello", "content");
//        // when
//        Long save = articleRepository.save(article);
//
//
//
//        // Article findArticle = articleRepository.findById(saveArticleId);
//
//
//        // then
//        // assertThat(saveArticleId).isEqualTo(findArticle.getId());
//
//
//    }
//    @Test
//    @DisplayName("게시글 수정")
//    public void modify() throws Exception {
//        // given
//
//        // when
//        // then
//
//    }
    @Test
    @DisplayName("모든 게시글 불러오기")
    public void findAllArticle() throws Exception {
        // given

        // when
        List<Article> all = articleRepository.findAll();
        int size = all.size();
        // then
        Assertions.assertThat(size).isEqualTo(6);
    }
}