package com.miraeson.mini_site.api;

import com.miraeson.domain.User;
import com.miraeson.mini_site.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserApiController {
    private final UserService userService;


    @PostMapping
    public CreateUserResponse login(@RequestBody Map<String, String> list, HttpServletResponse httpServletResponse) {
        String username = list.get("username");
        String avatar = list.get("avatar");
        String email = list.get("email");
        String token = list.get("token");

        if(token != null){
            User user = new User(username, avatar, email);
            // 로그인을 한다.
            User loginUser = userService.createUser(user);
            httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
            httpServletResponse.setHeader("Access-Control-Allow-Headers","Content-Type,Authorization,X-Amz-Date,X-Api-Key,X-Amz-Security-Token");
            httpServletResponse.setHeader("Access-Control-Allow-Methods","DELETE,GET,HEAD,OPTIONS,PATCH,POST,PUT");
            return new CreateUserResponse(loginUser.getUsername(), loginUser.getAvatar(), loginUser.getEmail(), loginUser.getId().toString());
        }

        return new CreateUserResponse();


    }
    @PostMapping("/login/anony")
    public CreateAnonyResponse login(HttpServletResponse httpServletResponse) {

        Long anonymous = userService.createAnonymous();
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","Content-Type,Authorization,X-Amz-Date,X-Api-Key,X-Amz-Security-Token");
        httpServletResponse.setHeader("Access-Control-Allow-Methods","DELETE,GET,HEAD,OPTIONS,PATCH,POST,PUT");
        return new CreateAnonyResponse(anonymous.toString());


    }
    @Data @AllArgsConstructor @NoArgsConstructor
    private static class CreateAnonyResponse{
        private String token;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    private static class CreateUserResponse{
        private String username;
        private String avatar;
        private String email;
        private String token;


    }
}
