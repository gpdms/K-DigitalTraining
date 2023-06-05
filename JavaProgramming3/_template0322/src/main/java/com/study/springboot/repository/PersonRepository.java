package com.study.springboot.repository;

import com.study.springboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> { //<테이블명,PK타입>

    @Query(value = "select * from person", nativeQuery = true)
    List<Person> select();

    @Modifying
    @Transactional //insert,update,delete는 modifying, transactional 넣어주기!
    @Query(value = "insert into person(name, addr, age) values(:#{#person.name}, :#{#person.addr}, :#{#person.age})", nativeQuery = true)
    void insert(@Param("person") Person person);
}
