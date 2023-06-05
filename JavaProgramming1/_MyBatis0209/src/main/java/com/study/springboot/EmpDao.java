package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpDao {
	public List<Emp> list();
	public int write(Emp emp); //preparestatement같은거return값이 int니까.
	public Emp viewOne(int empno);
	public int update (Emp emp);
	
	//어노테이션이랑 xml 같이 써도 
//	@Update("update")
//	public int update (Emp emp);
	
}
