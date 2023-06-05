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
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private String hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
}
