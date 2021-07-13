package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;

import java.math.BigInteger;
import java.util.List;


public interface ArticleRepository {
    // Article 수정 및 저장
    Long save(Article article);
    // Id로 찾기
    Article findById(Long id);
    // 모든 Article 찾기
    List<Article> findAll();
}
