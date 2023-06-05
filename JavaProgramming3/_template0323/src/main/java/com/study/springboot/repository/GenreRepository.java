package com.study.springboot.repository;

import com.study.springboot.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
