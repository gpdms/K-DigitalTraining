package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{//<테이블명, 그 테이블의 PK의 자료형

}
