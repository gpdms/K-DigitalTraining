package com.study.springboot.jdbc;


import com.study.springboot.dto.Dept;
import com.study.springboot.dto.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpDeptMapper {
	public List<Emp> findAllEmp( @Param("search") String search,
			                     @Param("type") String type);
	public List<Dept> findAllDept();
}
