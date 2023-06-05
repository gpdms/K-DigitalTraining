package com.study.springboot0225;

import com.study.springboot0225.entity.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Log4j2
public class EntityManager {

    @PersistenceContext
    javax.persistence.EntityManager em;

    @Transactional
    public void personCreate() {

        log.info("entityManager properties : " + em.getProperties());


        Person person = Person.builder().name("홍길철").addr("마포").age(32).build();

            // persistence context 등록 전
        log.info("user.getId : " + person.getId());

        em.persist(person);

            // persistence context 등록 후
        log.info("user.getId : " + person.getId());

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
    }
}
