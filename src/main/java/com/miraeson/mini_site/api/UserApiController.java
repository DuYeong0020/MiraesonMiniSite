package com.miraeson.mini_site.api;

import com.miraeson.domain.User;
import com.miraeson.mini_site.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserApiController {
    private static UserService userService;


    @RequestMapping(value = "/login/google", method = RequestMethod.POST)
    @ResponseBody() // JSON
    public Map<String, String> login(@RequestBody Map<String, String> list) {
        Map<String, String> map = new HashMap<>();


        String username = list.get("username");
        String avatar = list.get("avatar");
        String email = list.get("email");
        String token = list.get("token");

        // 출력
        System.out.println("username = " + username);
        System.out.println("avatar = " + avatar);
        System.out.println("email = " + email);
        System.out.println("token = " + token);

        if(token != null){
            User user = new User(username, avatar, email);
            // 로그인을 한다.
            User loginUser = userService.createUser(user);
            map.put("token", loginUser.getId().toString());
            map.put("username", loginUser.getUsername());
            map.put("avatar", loginUser.getAvatar());
            map.put("social_type", loginUser.getSocial_type().toString());
            map.put("admin", loginUser.getAdmin().toString());
            map.put("status", "200");


        }else{
            map.put("status", "400");
        }
        return map;

    }
}
