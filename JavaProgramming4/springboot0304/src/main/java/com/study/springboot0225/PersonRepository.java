package com.study.springboot0225;

import com.study.springboot0225.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select * from person", nativeQuery = true)
    List<Person> select();

    @Modifying
    @Transactional
    @Query(value = "insert into person(name, addr, age) values(:#{#person.name}, :#{#person.addr}, :#{#person.age})", nativeQuery = true)
    void insert(@Param("person") Person person);
}
