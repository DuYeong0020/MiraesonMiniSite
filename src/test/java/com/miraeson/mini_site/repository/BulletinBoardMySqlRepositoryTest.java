package com.miraeson.mini_site.repository;

import com.miraeson.domain.BulletinBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest @ExtendWith(SpringExtension.class)
class BulletinBoardMySqlRepositoryTest {

    @Autowired
    BulletinBoardMySqlRepository bulletinBoardH2Repository;

    @Test
    @Transactional
    public void testBulletinTest() throws Exception {
        // given
        BulletinBoard bulletinBoard = new BulletinBoard();

        // when
        Long save = bulletinBoardH2Repository.save(bulletinBoard);
        BulletinBoard findBulletinBoard = bulletinBoardH2Repository.findById(save);

        // then
        assertThat(findBulletinBoard.getBulletinBoardId()).isEqualTo(bulletinBoard.getBulletinBoardId());


    }
}