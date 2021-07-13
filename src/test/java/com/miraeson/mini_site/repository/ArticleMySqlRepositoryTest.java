package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMySqlRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;


}