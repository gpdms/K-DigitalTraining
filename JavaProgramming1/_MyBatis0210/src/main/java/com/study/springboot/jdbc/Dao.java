package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Dao {
	public List<BoardDto> findAll();
}
