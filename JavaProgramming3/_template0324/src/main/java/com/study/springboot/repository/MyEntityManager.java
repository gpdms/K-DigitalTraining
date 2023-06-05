package com.study.springboot.repository;

import com.study.springboot.entity.Cart;
import com.study.springboot.entity.Person;
import com.study.springboot.entity.Product;
import com.study.springboot.entity.Rec;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.IntStream;

@Repository
@Log4j2
public class MyEntityManager {
    @PersistenceContext
    EntityManager em;
    @Transactional
    public String create() {
        Person person = Person.builder().name("홍길동")
                .addr("마포구").build();
        em.persist(person);
        IntStream.rangeClosed(1, 10).forEach(t->{
            Rec rec = Rec.builder().content("홍"+t+" 기록").person(person).build();
            em.persist(rec);
        });

        return "입력";
    }

    @Transactional
    public String update() {
//        Person person = em.find(Person.class, 1L);
//        person.setAddr("성남");
        Person person = Person.builder().id(2L).name("가나다")
                .addr("수원").build();
        em.merge(person);
        return "수정";
    }

    public List<Person> selectAll() {
        String sql = "select p from Person p";
        List<Person> list = em.createQuery(sql, Person.class).getResultList();
        return  list;
    }

    @Transactional
    public String delete() {
        Person person = em.find(Person.class, 3L);
        //Person person = Person.builder().id(1L).build();
        //person = em.merge(person);
        System.out.println("######"+em.contains(person));
        em.remove(person);
        return "삭제";
    }

    @Transactional
    public String putInCart() {

        Cart cart = Cart.builder().build();
        em.persist(cart);
        log.info("===>카트생성?"+em.contains(cart));
        IntStream.rangeClosed(1, 5).forEach(t->{
            Product product = Product.builder().cart(cart)
                    .name("물건"+t).price(2000+t*10).build();
            em.persist(product);
            log.info("===>물건넣기?"+em.contains(product));
        });
        return "생성";
    }

    public Cart getCart() {
        Cart cart = em.find(Cart.class, 1L);
        return cart;
    }

    public Cart getCart2(Long id) {
        return em.find(Cart.class, id);
    }

}
