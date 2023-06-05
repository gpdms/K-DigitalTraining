package com.study.springboot.repository;

import com.study.springboot.entity.Cart;
import com.study.springboot.entity.Person;
import com.study.springboot.entity.Product;
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

    @PersistenceContext //EntityManager를 생성하고 주입하는 데 사용되는 어노테이션 //persistence.xml을 접근함. 옛날에는 factory쓰고...대신에 애너테이션.
    EntityManager em;

//--person-------------------------------
    @Transactional
    //persist,merge,remove는 영속성컨텍스트에서 관리되는거고,
    // 트랜잭션 commit해야 영속성컨텍스트를 flush(). 플러시 해야 DB에 반영.
    //Transactional이 commit하는 기능함.
    public String create() {
        IntStream.rangeClosed(1, 10).forEach(t->{
            Person person = Person.builder().name("홍"+t)
                    .addr("마포"+t).build();
            em.persist(person); //insert와 같은 기능
        });

        return "입력";
    }

    @Transactional
    public String update() {
        Person person = em.find(Person.class, 1L);
        person.setAddr("성남"); // 이렇게만해도 DB에 update됨.영속화됨. transaction끝나면서 flush됨.
//        Person person = Person.builder().id(2L).name("가나다")
//                .addr("수원").build();
        em.merge(person); //update 기능
        return "수정";
    }

    public List<Person> selectAll() {
        String sql = "select p from Person p"; //Native Query아님. Person이라는 테이블이름이 아니라 엔티티이름. 별칭p필수.
        List<Person> list = em.createQuery(sql, Person.class).getResultList(); //.class
        //query.getResultList():결과가 하나 이상인 경우, 리스트를 반환한다.
        //query.getSingleResult():결과가 정확히 하나, 단일 객체를 반환한다.(정확히 하나가 아니면 예외 발생)
        return  list;
    }

    @Transactional
    public String delete() {
//        Person person = em.find(Person.class, 1L);
//        log.info(person);
//        em.remove(person); //이렇게도 가능
        Person person = Person.builder().id(1L).build(); //자바VM 객체 생성.
        person = em.merge(person); //단순한 update가 아니고 영속성. DB에 있는 자료를 찾아옴.
        System.out.println("영속성 있음?"+em.contains(person)); //영속성이 있으면 true, 없으면 false.
        em.remove(person);
        return "삭제";
    }

//--Cart-------------------------------------------
    @Transactional
    public String putInCart(){
        Cart cart = Cart.builder().build();
        em.persist(cart);
        log.info("--->카트생성?"+em.contains(cart));
        IntStream.rangeClosed(1,5).forEach(t->{
            Product product = Product.builder().cart(cart).name("물건"+t).price(2000+t*10).build();
        em.persist(product);
        log.info("--->물건넣기?"+em.contains(product));
        });
        return "생성";
    }


    public Cart getCart(){
        Cart cart = em.find(Cart.class, 1L);
        return cart;
    }

    public Cart getCart2(Long id){
        return em.find(Cart.class, id);
    }
}
