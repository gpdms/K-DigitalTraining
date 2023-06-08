package com.study.springboot.repository;

import com.study.springboot.entity.Person;
import com.study.springboot.entity.Rec;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testIns() {
        System.out.println("entityManager properties : " + em.getProperties());
        Person person = Person.builder().name("홍").addr("마포").age(24).build();

        // persistence context 등록 전
        System.out.println("user.getId : " + person.getId());

        em.persist(person);
        System.out.println("1--->"+em.contains(person));

        // persistence context 등록 후
        System.out.println("user.getId : " + person.getId());

        IntStream.rangeClosed(1, 10).forEach(t->{
            Rec rec = Rec.builder().person(person).content("테스트"+t).build();
            em.persist(rec);
            System.out.println("*--->"+em.contains(rec));
        });
        em.flush();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testSel() {
        Person parent = em.find(Person.class, 2L);
        System.out.println("P--->"+em.contains(parent));
        List<Rec> childEntities = parent.getRecList();
        childEntities.stream().forEach(r->{
            System.out.println(r);
        });
        em.remove(parent);
    }
}