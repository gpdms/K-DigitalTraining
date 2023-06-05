package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class CrudApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	
	DeptDao deptdao;
	
	@Autowired

	public CrudApplicationTests(DeptDao deptdao) {
		super();
		this.deptdao = deptdao;
	}	
	
	@Test
	@DisplayName("--deptdaoTest---")
	void deptList() {
		List<Dept>list =deptdao.selectAll();
		log.info("log============="+list);
	}
	
	@Test
	@DisplayName("dept update 테스트")
	public void testUpdate() {
		Dept dept = Dept.builder().deptno(40).dname("sales").loc("뉴욕").build();
		log.info("---------log"+ dept);
		int res = deptdao.update(dept);
		Assertions.assertEquals(res, 1);
	}
}
