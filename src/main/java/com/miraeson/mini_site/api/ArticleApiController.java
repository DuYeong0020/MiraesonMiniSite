package com.miraeson.mini_site.api;


import com.miraeson.domain.Article;
import com.miraeson.domain.User;
import com.miraeson.mini_site.repository.ArticleRepository;
import com.miraeson.mini_site.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ArticleApiController {

//    private final ArticleRepository articleRepository;
//
//    @GetMapping("/article")
//    public List<Article> findAllArticle() {
//        List<Article> all = articleRepository.findAll();
//        for (: all) {
//
//        }
//    }
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    private static class ArticleResponse{
//        private String id;
//        private String username;
//        private String board;
//        private String title;
//        private String content;
//        private String created_time;
//        private String updated_time;
//        private String views;
//
//
//    }

}
