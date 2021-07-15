package com.miraeson.mini_site.repository;

import com.miraeson.mini_site.domain.Comment;
import com.miraeson.mini_site.domain.QArticle;
import com.miraeson.mini_site.domain.QComment;
import com.miraeson.mini_site.domain.QUser;
import com.miraeson.mini_site.dto.CommentDTO;
import com.miraeson.mini_site.dto.QArticleDTO;
import com.miraeson.mini_site.dto.QCommentDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository @Transactional @RequiredArgsConstructor
public class CommentMySqlRepository implements CommentRepository {

    @PersistenceContext
    private final EntityManager em;


    // 게시글 아이디 가지고 모든 댓글 데이터 가지고 오기
    @Override
    public List<CommentDTO> findAll(Long id) {
        em.flush();
        em.clear();

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QUser user = QUser.user;
        QComment comment = QComment.comment;


        List<CommentDTO> fetch = queryFactory.select(new QCommentDTO(comment.id, comment.article.id, user.id, comment.content, comment.created_time, user.username, user.avatar))
                .from(comment)
                .join(comment.user, user)
                .where(comment.article.id.eq(id))
                .fetch();
        return fetch;
    }

    @Override
    public Comment findById(Long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public Long saveComment(Comment comment) {
        if(comment.getId() == null){ // 새로 댓글 작성
            em.persist(comment);
        }else { // 댓글 수정
            em.merge(comment);

        }

        return comment.getId();
    }

    @Override
    public void deleteComment(Comment comment) {
        em.remove(comment);
    }
}
