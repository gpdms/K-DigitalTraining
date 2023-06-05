package com.study.springboot.jdbc;


import com.study.springboot.dto.Dept;
import com.study.springboot.dto.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper //import: ibatis
public interface EmpDeptMapper {
	public List<Emp> findAllEmp( @Param("search") String search,
									@Param("type") String type);
	public List<Dept> findAllDept();

	//mapper에 resultType이 Emp인데 List로 받는 것 가능.
}
