package com.miraeson.mini_site.service;


import com.miraeson.mini_site.domain.Article;
import com.miraeson.mini_site.domain.Comment;
import com.miraeson.mini_site.domain.User;
import com.miraeson.mini_site.dto.CommentDTO;
import com.miraeson.mini_site.repository.ArticleRepository;
import com.miraeson.mini_site.repository.CommentRepository;
import com.miraeson.mini_site.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional @Service @RequiredArgsConstructor
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public List<CommentDTO>seeAllComments(Long id) {
        List<CommentDTO> all = commentRepository.findAll(id);

        return all;

    }
    public Long writeComment(Long id, Long token, String content){
        Article findArticle = articleRepository.findById(id);
        User findUser = userRepository.findById(token);

        return commentRepository.saveComment(new Comment(findUser, findArticle, content));

    }
    public Long modifyComment(Long id, String content) {
        Comment findComment = commentRepository.findById(id);
        findComment.setContent(content);

        return commentRepository.saveComment(findComment);

    }
    public void deleteComment(Long id){
        Comment findComment = commentRepository.findById(id);
        commentRepository.deleteComment(findComment);
    }
}
