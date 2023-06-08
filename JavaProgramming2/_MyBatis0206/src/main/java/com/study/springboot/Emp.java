package com.study.springboot;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//lombok: getter setter 안만들어도 자동으로 해주는 기능.

@Getter
@Setter
@ToString
//@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private int newEmpno;
}
