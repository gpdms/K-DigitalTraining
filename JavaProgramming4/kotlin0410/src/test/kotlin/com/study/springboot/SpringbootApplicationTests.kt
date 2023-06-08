package com.study.springboot

import com.study.springboot.entity.Dept
import com.study.springboot.repository.DeptRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringbootApplicationTests {


	@Autowired
	lateinit var deptRepository: DeptRepository

	@Test
	fun contextLoads() {
		println("test")
	}

	fun aaa(){
		println("함수")
	}

	@Test
	fun test1(){
		println("연습")
		aaa()
	}

	@Test
	fun test2(){
		val list: List<Dept?> = deptRepository.findAll()
	}

}
