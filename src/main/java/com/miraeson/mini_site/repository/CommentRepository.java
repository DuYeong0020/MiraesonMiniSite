package com.miraeson.mini_site.repository;

import com.miraeson.mini_site.domain.Comment;
import com.miraeson.mini_site.dto.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository{
    // 게시물의 id값으로 모든 댓글 가져오기
    List<CommentDTO>findAll(Long id);
    // 댓글 id값으로 댓글 객체 가져오기
    Comment findById(Long id);


    // 게시물에 대한 댓글 작성 댓글 수정, 댓글 아이디가 존재하면 수정, 아니면 저장
    Long saveComment(Comment comment);

    // 댓글 삭제(delete로 삭제하기)
    void deleteComment(Comment comment);

}
