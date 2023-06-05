package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;
	
	
	@Test
	void contextLoads() {
	}

	//mybatis 사용
	@Test
	public void testMyBatisFindAllEmp() {
		List<Emp> list = empDeptMapper.findAllEmp("78", "S");
		log.info(list);
	}
	
	//jpa사용
	@Test
	public void testFindAllEmp() {
		List<Emp> list = empRepository.findAll();
		log.info(list);
	}
	
}
