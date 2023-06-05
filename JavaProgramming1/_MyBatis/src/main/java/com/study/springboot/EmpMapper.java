package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper //어노테이션 잊지말기! import해주기
public interface EmpMapper {
	@Select("select empno, ename, job, sal from emp_temp")
	List<Emp> findAll();
	
	@Insert("INSERT INTO emp_temp(empno, ename, job, sal) VALUES(#{empno}, #{ename}, #{job}, #{sal})")
	int save(Emp emp);
	
	@Delete("delete from emp_temp where empno = #{empno}")
	int delete(int empno);
	
}
