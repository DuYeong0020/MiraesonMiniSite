package com.miraeson.mini_site.api;

import com.miraeson.mini_site.dto.ArticleDTO;
import com.miraeson.mini_site.dto.CommentDTO;
import com.miraeson.mini_site.service.ArticleService;
import com.miraeson.mini_site.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CommentApiController {


    private final CommentService commentService;



    // 특정 게시물의 모든 댓글 보기
    @GetMapping("comment/{id}")
    public List<CommentDTO> findAllArticle(@PathVariable Long id) {
        return commentService.seeAllComments(id);
    }
    // 댓글 작성하기
    @PostMapping("comment")
    public void writeComment(@RequestBody Map<String, String> list){
        String id = list.get("id"); // 게시물 아이디
        String token = list.get("token"); // 유저 PK
        String content = list.get("content");
        Long result = commentService.writeComment(Long.parseLong(id), Long.parseLong(token), content);
    }

    // 댓글 수정하기
    @PutMapping("comment")
    public void modifyComment(@RequestBody Map<String, String> list){
        String id = list.get("id");
        String content = list.get("content");

        commentService.modifyComment(Long.parseLong(id), content);
    }
    @DeleteMapping("comment/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
