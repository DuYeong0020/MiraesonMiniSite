package com.miraeson.mini_site.service;

import com.miraeson.domain.Article;

import com.miraeson.mini_site.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 생성
public class ArticleService{

    private final ArticleRepository articleRepository;

    public List<Article> lookupAllArticle() {
        return articleRepository.findAll();
    }
}
