package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
