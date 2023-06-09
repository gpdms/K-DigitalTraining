package com.study.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Emp {
	@Id
	private int empno;
	
	private String ename;
	private String job;
	private Integer mgr; //null값있으면 오류뜨기때문에 int아닌 Integer로 해주기. Integer는 null을 포함.
	private String hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
}
