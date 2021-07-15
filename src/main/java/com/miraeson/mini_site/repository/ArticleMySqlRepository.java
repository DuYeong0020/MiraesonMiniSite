package com.miraeson.mini_site.repository;

import com.miraeson.mini_site.domain.Article;
import com.miraeson.mini_site.domain.QArticle;
import com.miraeson.mini_site.domain.QUser;
import com.miraeson.mini_site.domain.User;
import com.miraeson.mini_site.dto.ArticleDTO;
import com.miraeson.mini_site.dto.QArticleDTO;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository  @RequiredArgsConstructor
public class ArticleMySqlRepository implements ArticleRepository  {

    @PersistenceContext
    private final EntityManager em;





    // 게시글 작성 및 수정 메서드
    @Transactional
    public Long save(Article article){
        if(article.getId() == null){ // 새로 게시글 작성
            em.persist(article);
        }else { // 게시글 수정
            em.merge(article);

        }

        return article.getId();
    }
    // Id로 게시글 불러오기
    @Transactional
    public Article findById(Long id){
        return em.find(Article.class, id);
    }



    // 모든 게시글 불러오기
    @Transactional @Query
    public List<ArticleDTO> findAll(){
        em.flush();
        em.clear();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QArticle article = QArticle.article;
        QUser user = QUser.user;
        // list는 fetch
        List<ArticleDTO> fetch = queryFactory
                .select(new QArticleDTO(article.id, user.username,article.board , article.title, article.content, article.created_time, article.updated_time, article.views))
                .from(article)
                .join(article.user, user)
                .where(article.deleted.eq(0))
                .orderBy(article.created_time.desc())
                .fetch();

        return fetch;

    }
    // 조회수 1 증가하여 업데이트 하기
    @Transactional
    public Long updateViews(Article article){
        article.setViews(article.getViews()+1);
        em.merge(article);


        return article.getId();

    }
    // 삭제시 delted를 1로 수정
    @Transactional
    public Long updateDeleted(Article article){
        article.setDeleted(1);
        em.merge(article);

        return article.getId();
    }





}
