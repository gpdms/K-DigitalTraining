package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptDao {

	public List<Dept>selectAll();
	public int update(Dept dept);
	public Dept viewOne(int deptno);
	
}
