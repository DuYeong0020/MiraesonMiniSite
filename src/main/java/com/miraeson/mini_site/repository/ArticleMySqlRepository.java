package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Repository @Transactional @RequiredArgsConstructor
public class ArticleMySqlRepository implements ArticleRepository  {

    @PersistenceContext
    private final EntityManager em;

    // 게시글 작성 및 수정 메서드
    public Long save(Article article){
        if(article.getId() == null){ // 새로 게시글 작성
            em.persist(article);
        }else { // 게시글 수정
            em.merge(article);

        }

        System.out.println("article.getId() = " + article.getId());
        System.out.println("article.getUser().getId() = " + article.getUser().getId());


        return article.getId();
    }
    // Id로 게시글 불러오기
    public Article findById(Long id){
        return em.find(Article.class, id);
    }
    // 모든 게시글 불러오기
    public List<Article> findAll(){
        return em.createQuery("select a from Article a", Article.class).getResultList();
    }
}
