package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{ //<entity, entity(primarykey)의 데이터타입>

}
