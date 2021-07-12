package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ArticleMySqlRepository implements ArticleRepository {

    @PersistenceContext
    private EntityManager em;

    // 게시글 db저장
    public Long save(Article article) {
        em.persist(article);
        return article.getBulletinBoardId();
    }

    // 모든 객체 찾아오기
    public List<Article> findAll() {
        return em.createQuery("select b from Article b", Article.class)
                .getResultList();
    }
    // ID로 객체 찾아오기
    public Article findById(Long bulletinBoardId) {
        return em.find(Article.class, bulletinBoardId);
    }
}
