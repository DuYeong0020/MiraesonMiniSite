package com.miraeson.mini_site.api;

import com.miraeson.mini_site.domain.User;
import com.miraeson.mini_site.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserApiController {
    private final UserService userService;


    @PostMapping("/login/google")
    public CreateUserResponse login(@RequestBody Map<String, String> list) {
        String username = list.get("username");
        String avatar = list.get("avatar");
        String email = list.get("email");
        String token = list.get("token");

        if(token != null){
            User user = new User(username, avatar, email);
            // 로그인을 한다.

            User loginUser = userService.createUser(user);
            return new CreateUserResponse(loginUser.getUsername(), loginUser.getAvatar(), loginUser.getAdmin().toString(), loginUser.getSocial_type().toString(),loginUser.getId().toString());
        }

        return new CreateUserResponse();


    }
    @PostMapping("/login/anony")
    public CreateAnonyResponse login() {

        Long anonymous = userService.createAnonymous();
        return new CreateAnonyResponse(anonymous.toString());


    }
    @Data @AllArgsConstructor @NoArgsConstructor
    private static class CreateAnonyResponse{
        private String insertId;

    }
    @Data @AllArgsConstructor @NoArgsConstructor
    private static class CreateUserResponse{
        private String username;
        private String avatar;
        private String admin; // 추가
        private String social_type; // 추가
        private String token;


    }
}
