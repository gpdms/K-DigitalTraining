package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
