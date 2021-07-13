package com.miraeson.mini_site.service;

import com.miraeson.domain.User;
import com.miraeson.mini_site.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 생성
public class UserService {


    private final UserRepository userRepository;

    // 로그인하기
    @Transactional
    public User createUser(User user){
        // 이름으로 조회해서
        List<User> findUsers = userRepository.findByName(user.getUsername());
        int size = findUsers.size();
        if(size == 0){ // row가 0이라면 신규회원
            // 넘길 유저를 셋팅한다.
            User saveUser = new User(user.getUsername(), user.getAvatar(), user.getEmail(),200);
            // db에 저장한다.
            Long saveUserId = userRepository.save(saveUser);
            // 값으로 확인하여 return 해준다.
            User findUser = userRepository.findById(saveUserId);
            return findUser;

        }else{ // 만약 row가 0이 아니라면 기존 회원
            return findUsers.get(0);

        }
    }

    @Transactional
    public Long createAnonymous(){
        User user = new User();
        // 익명으로 가입하기
        Long saveAnonymous = userRepository.save(user);

        return saveAnonymous;
    }

}
