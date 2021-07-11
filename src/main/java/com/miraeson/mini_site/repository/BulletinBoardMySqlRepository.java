package com.miraeson.mini_site.repository;

import com.miraeson.domain.BulletinBoard;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BulletinBoardMySqlRepository implements BulletinBoardRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(BulletinBoard bulletinBoard) {
        em.persist(bulletinBoard);
        return bulletinBoard.getBulletinBoardId();
    }
    public BulletinBoard findById(Long bulletinBoardId) {
        return em.find(BulletinBoard.class, bulletinBoardId);
    }
}
