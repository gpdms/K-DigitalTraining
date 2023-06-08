package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0208ApplicationTests {

	EmpDao empDao;
	
	@Autowired
	public MyBatis0208ApplicationTests(EmpDao empDao) {
		this.empDao = empDao;
	}


	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("emp_temp 리스트 테스트")
	public void testList() {
		List<Emp> list = empDao.list();
		log.info(list);
	}
	
	//@Test
	@DisplayName("emp_temp 쓰기 테스트")
	public void testWrite() {
//		Emp emp = new Emp();
//		emp.setEmpno(1234);
//		emp.setEname("김기사");
//		emp.setJob("사원");
//		emp.setSal(3500);
		Emp emp = Emp.builder().empno(8080)
				.ename("홍길준").job("부장").sal(8000)
				.build();
		log.info(emp);
		int res = empDao.write(emp);
		assertThat(res).isEqualTo(1);
	}

	@Test
	@DisplayName("emp_temp 읽기 테스트")
	public void testViewOne() {
		Emp emp = empDao.viewOne(5454);
		log.info(emp);
		assertThat(emp.getEmpno()).isEqualTo(5454);
	}
	
}
