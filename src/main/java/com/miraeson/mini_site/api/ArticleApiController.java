package com.miraeson.mini_site.api;


import com.miraeson.mini_site.domain.Article;
import com.miraeson.mini_site.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArticleApiController {

    private final ArticleService articleService;

    @GetMapping("/article")
    public List<Article> findAllArticle(HttpServletResponse httpServletResponse) {
        List<Article> allArticle = articleService.findAllArticle();

        return allArticle;

    }
    @PostMapping("/article")
    public CreateArticleResponse writeArticle(@RequestBody Map<String, String> list, HttpServletResponse httpServletResponse) {
        String token = list.get("token");
        String title = list.get("title");
        String board = list.get("board");
        String content = list.get("content");

        if(token != null){
            Article article = new Article(Integer.parseInt(board), title, content);

            Article writeArticle = articleService.writeArticle(Long.parseLong(token), article);


            return new CreateArticleResponse(writeArticle.getUser().getId().toString(),
                    writeArticle.getTitle(), writeArticle.getBoard().toString(), writeArticle.getContent());
        }

        return new CreateArticleResponse();


    }
    @PutMapping("/article")
    public void modifyArticle(@RequestBody Map<String, String> list, HttpServletResponse httpServletResponse) {
        String id = list.get("id");
        String title = list.get("title");
        String content = list.get("content");

        if(id != null){
            Article article = new Article(title, content, Long.parseLong(id));
            articleService.modifyArticle(article);

        }

        return;


    }
    @Data @AllArgsConstructor @NoArgsConstructor
    private static class CreateArticleResponse{
        private String id;
        private String title;
        private String board;
        private String content;
    }

}
