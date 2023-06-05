package com.study.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Movie;
import com.study.springboot.entity.Genre;
import com.study.springboot.repository.MovieRepository;
import com.study.springboot.repository.GenreRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MiniPj0224ApplicationTests {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	
	@Test
	void testInsertDetail() {
		Genre genre = new Genre();
		genre.setGenre("액션");
		log.info("장르:----------"+genre);
		
		
		
		
		log.info(genreRepository.save(genre));		
		
		
	}

}
