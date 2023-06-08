package com.study.springboot0225;

import com.study.springboot0225.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class Springboot0225ApplicationTests {

	@Autowired
	PersonRepository personRepository;
	@Test
	void contextLoads() {
	}

	@Test
	//@Transactional
	void test() {
		IntStream.rangeClosed(1,10).forEach(i->{
			Person person = Person.builder().name("이름"+i).addr("서울"+i).age(i+10).build();
			//personRepository.save(person);
			personRepository.insert(person);
		});
		//List<Person> list = personRepository.findAll();
		List<Person> list = personRepository.select();
		list.stream().forEach(i->{
			System.out.println(i);
		});
	}

}
