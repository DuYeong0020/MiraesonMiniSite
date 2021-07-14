package com.miraeson.mini_site.repository;

import com.miraeson.mini_site.dto.ArticleDTO;
import com.querydsl.core.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class ArticleMySqlRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test @Transactional
    public void hello() throws Exception {
        // given
        List<ArticleDTO> all = articleRepository.findAll();
        // when
        for (ArticleDTO a:
             all) {
            System.out.println("a = " + a);
        }
        // then

    }

}