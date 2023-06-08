package com.study.springboot.repository;

import com.study.springboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

//@Repository 써도되고 안써도
public interface PersonRepository extends JpaRepository<Person, Long> {
    //인터페이스명에 마우스오른쪽-Go To-Test-create new test

    //기본메소드
//    Person findPersonByName(String name);

//    List<Person> findPersonByNameLike(String name);

    List<Person> findPersonByNameLikeOrderByPidDesc(String name); //pid내림차순 정렬


    //JPQL
    @Query(value = "select * from person", nativeQuery = true) //nativeQuery: ""안에 일반적인 쿼리문 쓸 수 있게.
    //여기다가 조인할 수 있음. 원래 조인 못함...?
    List<Person> selectAll(); //임의로 메소드명 만듦.

    @Query(value = "select * from person where name like %:name%", nativeQuery = true)
    List<Person> selectName(@Param("name") String name); //@Param습관처럼 그냥 써주기. param에 "name"은 :name을 의미.


    @Transactional //선생님은 이거 빠지면 오류났는데,, 나는 빠져도 오류안났음. 왜?
    @Modifying //insert, update, delete에는 modifying넣어주기. 왜??
    @Query(value = "insert into person(name, addr) values (:name, :addr)", nativeQuery = true)
    //insert는 return타입이 void or int
    void insertPerson(@Param("name") String name, @Param("addr") String addr);

    //객체타입으로 받기
    @Transactional
    @Modifying
    @Query(value = "insert into person(name, addr) values (:#{#person.name}, :#{#person.addr})", nativeQuery = true)
    void insertPerson2(@Param("person") Person person);
    
    
}
