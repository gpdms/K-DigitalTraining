package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer>{

}
