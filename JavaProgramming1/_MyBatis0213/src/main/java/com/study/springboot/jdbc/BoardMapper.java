package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper 
public interface BoardMapper {
	public List<Board> findAll(String writer);
}
