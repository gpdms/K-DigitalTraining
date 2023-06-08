package com.study.springboot.entity;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.IntStream;

@Repository
@Log4j2
public class TestEntityManager {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void personCreate() {

        log.info("entityManager properties : " + em.getProperties());
        Person person = Person.builder().name("홍").addr("마포").age(24).build();

        // persistence context 등록 전
        log.info("user.getId : " + person.getId());

        em.persist(person);

        // persistence context 등록 후
        log.info("user.getId : " + person.getId());

        IntStream.rangeClosed(1, 10).forEach(t->{
            Rec rec = Rec.builder().person(person).content("테스트"+t).build();
            em.persist(rec);
        });


    }

    @Transactional
    public void personSelect() {
        TypedQuery<Person> userQuery = em.createQuery("SELECT u FROM Person u ", Person.class);

        // pk를 이용한 entity 탐색
        List<Person> userList = userQuery.getResultList();
        if (userList.isEmpty()) {
            return;
        }

        Person userData = userList.get(0);
        log.info("personData : " + userData);
//        userData.getRecList().stream().forEach(i->{
//            log.info("personData : " + i);
//        });

    }
}
