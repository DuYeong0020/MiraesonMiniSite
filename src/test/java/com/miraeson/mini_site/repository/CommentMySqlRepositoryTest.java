package com.miraeson.mini_site.repository;

import com.miraeson.mini_site.dto.CommentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest @Transactional
class CommentMySqlRepositoryTest {

    @Autowired
    CommentMySqlRepository commentMySqlRepository; // 필드 주입

    @Test @Transactional
    public void findAllByArticleId() throws Exception {
        // given
        Long id = 2L;
        // when
        List<CommentDTO> all = commentMySqlRepository.findAll(id);
        // then
        for (CommentDTO a:
             all) {
            System.out.println("a = " + a);
        }

    }
}