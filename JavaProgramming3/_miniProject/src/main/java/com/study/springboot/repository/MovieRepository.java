package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
