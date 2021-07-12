package com.miraeson.mini_site.api;


import com.miraeson.domain.Article;
import com.miraeson.mini_site.service.ArticleService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleApiController {


    private final ArticleService articleService;

    @GetMapping(value = "/articles")
    public String list(Model model) {
        List<Article> articles = articleService.lookupAllArticle();
        model.addAttribute("articles", articles);
        return "articles/articlesList";
    }


}
