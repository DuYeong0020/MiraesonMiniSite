package com.miraeson.mini_site.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.miraeson.domain.Article;

import com.miraeson.domain.User;
import com.miraeson.mini_site.repository.ArticleRepository;
import com.miraeson.mini_site.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 생성
@Transactional
public class ArticleService{

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public List<Article> findAllArticle(){
        List<Article> all = articleRepository.findAll();
        return all;
    }
    public Article writeArticle(Long token, Article article){

        // 유저 찾아 Article에 대입
        User findUser = userRepository.findById(token);
        article.setUser(findUser);

        // 저장
        Long saveId = articleRepository.save(article);

        //탐색하여 리턴
        return articleRepository.findById(saveId);
    }
    public void modifyArticle(Article article){
        // 아이디로 값 찾기

        Article findArticle = articleRepository.findById(article.getId());
        Article modifyArticle = new Article(article.getId(),findArticle.getUser() ,findArticle.getBoard() ,article.getTitle() ,article.getContent(),
                findArticle.getCreated_time(), findArticle.getUpdated_time(), findArticle.getViews(), findArticle.getDeleted());

        articleRepository.save(modifyArticle);

    }


}
