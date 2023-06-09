package com.study.springboot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor	//파라미터가 없는 기본생성자.
@AllArgsConstructor //모든필드값을 파라미터로 받는 생성자를 만들어줌.
@Builder //new객체생성 대신 
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
