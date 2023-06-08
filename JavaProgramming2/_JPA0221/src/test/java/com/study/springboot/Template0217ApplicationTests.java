package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Master;
import com.study.springboot.entity.Slave;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.MasterRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired //자동으로 객체생성해서 wiring.
	MasterRepository masterRepository;
	
	@Test
	void contextLoads() {
	}
	@Disabled
	@Test
	public void testMyBatisFindAllEmp() {
		List<Emp> list 
		= empDeptMapper.findAllEmp("78", "S");
		log.info(list);
	}
	
	@Disabled
	@Test
	public void insertMasterSlave() {
		Master master = new Master(); //필드들 다 private인데 객체생성되는이유. 클래스가 public. 컴파일러가 디폴트로 기본생성자만들어줌.
		master.setCode("10");
		master.setComment("연습1");
		master.addSlave(
				Slave.builder().title("연습1").content("이것은연습1").build()
				);
		master.addSlave(
				Slave.builder().title("연습2").content("이것은연습2").build()
				);
		masterRepository.save(master);
		log.info(master.getMid());
	}
	

	@Test
	public void selectMasterSlave() {
		Master master = masterRepository.findById(2L).orElseThrow(); //master2번자료
		//List<Slave> slaveList = master.getSlaveList();
		log.info(master);
		
	}
	
	

}
