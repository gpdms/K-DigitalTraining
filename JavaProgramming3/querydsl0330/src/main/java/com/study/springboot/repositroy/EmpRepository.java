package com.study.springboot.repositroy;

import com.study.springboot.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EmpRepository extends JpaRepository<Emp, Long>, QuerydslPredicateExecutor<Emp> {
}
