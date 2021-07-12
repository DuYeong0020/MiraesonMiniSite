package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;

import java.util.List;


public interface ArticleRepository {
    Long save(Article article);


    List<Article> findAll();

    Article findById(Long bulletinBoardId);
}
