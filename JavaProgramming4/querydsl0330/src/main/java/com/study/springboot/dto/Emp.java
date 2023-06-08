package com.study.springboot.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
//@ToString
@Builder
@NoArgsConstructor
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private int newEmpno;
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}


}
