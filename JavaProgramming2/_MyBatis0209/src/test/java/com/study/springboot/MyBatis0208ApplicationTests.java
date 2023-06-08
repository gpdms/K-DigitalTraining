package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
	
	@Test
	@Disabled //Test를 주석처리하는 것 대신 
	@DisplayName("emp_temp 쓰기 테스트")
	public void testWrite() {
//		Emp emp = new Emp();
//		emp.setEmpno(1234);
//		emp.setEname("김기사");
//		emp.setJob("사원");
//		emp.setSal(3500);
		//위 이렇게 한줄로. 빌더패턴. Emp.java파일 참고 
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
	
	@Test
	@DisplayName("emp_temp 수정 테스트")
	public void testUpdate() {
		Emp emp = Emp.builder().empno(1234).ename("강감찬").job("사원").sal(3000).build(); //객체 생성된것.
											//수정할 이름.
		log.info(emp);
		int res = empDao.update(emp);
		Assertions.assertEquals(res, 1); //res값이 1이면 참.
	}
	
}
