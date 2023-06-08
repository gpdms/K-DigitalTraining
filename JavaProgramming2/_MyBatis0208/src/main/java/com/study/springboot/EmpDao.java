package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao {
	public List<Emp> list();
	public int write(Emp emp);
	public Emp viewOne(int empno);
}
