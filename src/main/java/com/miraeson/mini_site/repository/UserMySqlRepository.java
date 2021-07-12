package com.miraeson.mini_site.repository;

import com.miraeson.domain.Article;
import com.miraeson.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserMySqlRepository implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    // 유저 데이터를 가져와서 아이디 값 리턴하기
    @Override
    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }

    // 아이디로 유저 데이터 가져오기
    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    // 이름으로 유저 데이터 가져오기
    @Override
    public List<User> findByName(String name) {
        return em.createQuery("select u from User u where u.username = :name",
                User.class).setParameter("name", name)
                .getResultList();
    }
}
