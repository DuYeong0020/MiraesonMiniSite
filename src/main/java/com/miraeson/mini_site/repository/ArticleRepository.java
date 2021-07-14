package com.miraeson.mini_site.repository;

import com.miraeson.mini_site.domain.Article;
import com.miraeson.mini_site.dto.ArticleDTO;
import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ArticleRepository {
    // Article 수정 및 저장
    Long save(Article article);
    // Id로 찾기
    Article findById(Long id);
    // 모든 Article 찾기

    List<ArticleDTO> findAll();

    // 게시글 조회수 1증가 메서드
    Long updateViews(Article article);

    // 게시글 삭제 메서드
    Long updateDeleted(Article article);
}
