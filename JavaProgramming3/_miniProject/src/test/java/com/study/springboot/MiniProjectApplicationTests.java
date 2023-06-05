package com.study.springboot;

import com.study.springboot.entity.Genre;
import com.study.springboot.repository.GenreRepository;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Log4j2
class MiniProjectApplicationTests {

    @Autowired
    GenreRepository genreRepository;

    @Test
    public void insertGenre() {
        Genre genre1 = Genre.builder().genreName("액션").build();
        Genre genre2 = Genre.builder().genreName("코미디").build();
        Genre genre3 = Genre.builder().genreName("로맨스").build();
        Genre genre4 = Genre.builder().genreName("공포").build();
        List<Genre> genreList = Arrays.asList(genre1, genre2, genre3, genre4);
        genreRepository.saveAll(genreList);
    }

}
