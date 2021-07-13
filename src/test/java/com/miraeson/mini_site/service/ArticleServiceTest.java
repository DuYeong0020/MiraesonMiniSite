package com.miraeson.mini_site.service;

import com.miraeson.domain.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    @DisplayName("게시글 작성하기")
    public void writeArticle() throws Exception {
        // given
        Article requestArticle = new Article(null, 100, "title", "content");

        // when
        Article writeArticle = articleService.writeArticle(1L, requestArticle);


        // then

        assertThat(writeArticle.getId()).isNotEqualTo(null);

    }
}