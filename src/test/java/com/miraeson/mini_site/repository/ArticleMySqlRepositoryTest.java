package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest @ExtendWith(SpringExtension.class)
class ArticleMySqlRepositoryTest {

    @Autowired
    ArticleMySqlRepository articleMySqlRepository;

    @Test
    @Transactional
    @DisplayName("게시글 db저장 Test")
    public void bulletinSaveTest() throws Exception {
        // given
        Article article = new Article();

        // when
        Long save = articleMySqlRepository.save(article);
        Article findArticle = articleMySqlRepository.findById(save);

        // then
        assertThat(findArticle.getBulletinBoardId()).isEqualTo(article.getBulletinBoardId());


    }

    @Test
    @Transactional
    @DisplayName("게시글 전체 찾아오기")
    public void bulletinFindAllTest() throws Exception {
        // given
        Article board1 = new Article();
        Article board2 = new Article();
        Article board3 = new Article();

        articleMySqlRepository.save(board1);
        articleMySqlRepository.save(board2);
        articleMySqlRepository.save(board3);
        // 전체 찾아오기

        // when
        List<Article> all = articleMySqlRepository.findAll();
        // then
        Assertions.assertThat(all.size()).isEqualTo(10);

    }
}