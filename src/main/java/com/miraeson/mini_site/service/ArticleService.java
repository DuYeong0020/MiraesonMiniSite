package com.miraeson.mini_site.service;

import com.miraeson.mini_site.domain.Article;

import com.miraeson.mini_site.domain.User;
import com.miraeson.mini_site.dto.ArticleDTO;
import com.miraeson.mini_site.repository.ArticleRepository;
import com.miraeson.mini_site.repository.UserRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 생성
@Transactional
public class ArticleService{

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public List<ArticleDTO> findAllArticle(){
        List<ArticleDTO> all = articleRepository.findAll();
        return all;
    }
    // 게시글 작성하기
    public Article writeArticle(Long token, Article article){

        // 유저 찾아 Article에 대입
        User findUser = userRepository.findById(token);
        article.setUser(findUser);

        // 저장
        Long saveId = articleRepository.save(article);

        //탐색하여 리턴
        return articleRepository.findById(saveId);
    }
    // 게시글 수정하기
    public void modifyArticle(Article article){
        // 아이디로 값 찾기

        Article findArticle = articleRepository.findById(article.getId());
        // 수정하기 not null이면 조건 수행하는 걸로
        Article modifyArticle = new Article(article.getId(),findArticle.getUser() ,findArticle.getBoard() ,article.getTitle() ,article.getContent(),
                findArticle.getCreated_time(), findArticle.getUpdated_time(), findArticle.getViews(), findArticle.getDeleted());

        articleRepository.save(modifyArticle);

    }

    // 게시글 보기
    public Article seeArticle(Long id){
        // 게시글을 찾아서
        Article findArticle = articleRepository.findById(id);
        // 반영한다.
        Long modifyViews = articleRepository.updateViews(findArticle);

        return articleRepository.findById(modifyViews);


    }
    // 게시글 삭제하기
    public Long deleteArticle(Long id){
        // 게시글을 찾아서
        Article findArticle = articleRepository.findById(id);
        Long deletedArticleId = articleRepository.updateDeleted(findArticle);
        return deletedArticleId;
    }



}
