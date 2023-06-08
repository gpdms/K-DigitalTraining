package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.jdbc.BoardDto;
import com.study.springboot.jdbc.Dao;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0210ApplicationTests {

	private Dao dao; //인터페이스 Dao
	
	//생성자 만들기.source-generate constructor
	@Autowired
	public MyBatis0210ApplicationTests(Dao dao) {
		super();
		this.dao = dao;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("findAll 테스트")
	void testFindAll() {
		List<BoardDto> lst=dao.findAll();
		log.info(lst);
	}

}
