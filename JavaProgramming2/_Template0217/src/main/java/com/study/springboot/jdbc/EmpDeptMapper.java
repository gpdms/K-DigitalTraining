package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.entity.Dept;
import com.study.springboot.entity.Emp;

@Mapper
public interface EmpDeptMapper {
	public List<Emp> findAllEmp(@Param("search") String search, @Param("type") String type);
	//param을 안쓰면 mapper에서 인식하지 못함.
	public List<Dept> findAllDept();
}
