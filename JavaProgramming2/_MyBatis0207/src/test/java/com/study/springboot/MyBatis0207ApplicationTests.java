package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.dao.Emp;
import com.study.springboot.dao.EmpMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0207ApplicationTests {
	
	//dao테스트하려고.
	//의존성주입.안하면 null pointer오류.
	
	//필드주입: 권고하지 않음. 아래 setter or 생성자 쓰기
//	@Autowired 
	EmpMapper empMapper;
	
	//setter 주입방식.
//	@Autowired
//	public void setEmpMapper(EmpMapper empMapper) {
//		this.empMapper = empMapper;
//	}
	
	
	//생성자 주입방식
	//한번만 쓸거면 생성자 쓰기. 대체로 이것 씀.
	@Autowired
	public MyBatis0207ApplicationTests(EmpMapper empMapper) {
		super();
		this.empMapper = empMapper;
	}



	@Test
	void contextLoads() {
	}
	
	@Test
	void test() {
		log.info("*****로그 테스트*****");
		assertThat("aaa").isEqualTo("aaa"); //Junit참거짓판별. Run-run as -Junit Test
		Emp emp = empMapper.selectOne(7499);
		log.info(emp); //콘솔에서확인.
	}
	
}
