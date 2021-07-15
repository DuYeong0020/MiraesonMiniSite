package com.miraeson.mini_site.service;

import com.miraeson.mini_site.dto.CommentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired CommentService commentService;

    @Test
    public void findAllComments() throws Exception {

        // given
        List<CommentDTO> findAll = commentService.seeAllComments(2L);
        // when
        for (CommentDTO a:
             findAll) {
            System.out.println("a = " + a);
        }
        // then

    }
//    @Test
//    public void deleteById() throws Exception {
//        // given
//        commentService.deleteComment(3L);
//        // when
//        // then
//
//    }
}