package com.miraeson.mini_site.api;


import com.miraeson.mini_site.domain.Article;
import com.miraeson.mini_site.dto.ArticleDTO;
import com.miraeson.mini_site.service.ArticleService;
import com.querydsl.core.Tuple;
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

    // 모든 게시글 찾기
    @GetMapping("/article")
    public List<ArticleDTO> findAllArticle() {
        List<ArticleDTO> allArticle = articleService.findAllArticle();
        return allArticle;
    }
    // 게시글 등록
    @PostMapping("/article")
    public CreateArticleResponse writeArticle(@RequestBody Map<String, String> list) {
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
    // 게시글 수정
    @PutMapping("/article")
    public void modifyArticle(@RequestBody Map<String, String> list) {
        String id = list.get("id");
        String title = list.get("title");
        String content = list.get("content");

        if(id != null){
            Article article = new Article(title, content, Long.parseLong(id));
            articleService.modifyArticle(article);

        }

    }
    // 게시글 보기 및 조회수 수정
    @PutMapping("/article/{id}")
    public ArticleDTO seeArticle(@PathVariable String id) {
        Article article = articleService.seeArticle(Long.parseLong(id));
        return new ArticleDTO(article.getId(), article.getUser().getUsername(),article.getBoard(), article.getTitle(),
                article.getContent(), article.getCreated_time(), article.getUpdated_time(), article.getViews());
    }

    @Data @AllArgsConstructor @NoArgsConstructor
    private static class CreateArticleResponse{
        private String id;
        private String title;
        private String board;
        private String content;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    private static class SearchArticleResponse{
        private String id;
        private String username;
        private String board;
        private String title;

        private String content;
        private String created_time;
        private String updated_time;
        private String view;
    }


}
