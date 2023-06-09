package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.jdbc.Board;
import com.study.springboot.jdbc.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0213ApplicationTests {

	@Autowired //new안써도
	BoardMapper boardMapper;
	
	@Test
	void contextLoads() {
		log.info("-----------테스트 시작");
	}
	
	@Test
	@DisplayName("findAll test")
	void testFindAll() {
		List<Board> list = boardMapper.findAll("홍");
		log.info(list);
	}

}
