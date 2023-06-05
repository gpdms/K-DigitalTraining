package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.entity.Movie;
import com.study.springboot.entity.Genre;

@Mapper
public interface GenreDetailMapper {
	public List<Genre> findAllGenre();
	public List<Movie> findAllActionDetail(int genre_gid);
}
