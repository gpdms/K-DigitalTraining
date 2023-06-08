package com.study.springboot;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.MyData;
import com.study.springboot.repository.MyDataRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Jpa0215ApplicationTests {

	@Autowired
	MyDataRepository myDataRepository;
	
	@Test
	void contextLoads() {
	}
	
	//insert
	@Disabled
	@Test
	public void insertTest() {
		//10번 루프
		IntStream.rangeClosed(1, 10).forEach(t->{
			MyData myData = MyData.builder().memo("테스트"+t).build();
			log.info(myData);
			myDataRepository.save(myData); //save만든적 없는데. JpaRepository가만들어줌.
		});
		//MyData myData = new MyData(); //이렇게 객체생성 대신 빌더패턴써보기.
		
	}
	
	//select all
	@Disabled
	@Test
	public void selectAllTest() {
		List<MyData> list = myDataRepository.findAll();
		list.stream().forEach(i->{
			log.info(i);
		});
	}
	
	//update (id가 10인 행 수정)
	@Test
	@Disabled
	public void updateTest() {
		MyData mydata = MyData.builder().id(11L).memo("연습").build();
										//primarykey. L은 Long타입이어서.
		log.info(myDataRepository.save(mydata));
	}
	
	//delete
	@Disabled
	@Test
	public void deleteTest() {
		myDataRepository.deleteById(6L); //primarykey로 찾음. L은 Long타입.
	}
	
	//select one
	@Test
	public void selectOneTest() {
		//MyData mydata = myDataRepository.getOne(10L);
		MyData none = MyData.builder().memo("없음").build();
		Optional<MyData> mydata = myDataRepository.findById(100L);
		//Optional: null체크해줌.
		//log.info(mydata.get().getMemo());//Optional때문에 get()하나 더생김.
		log.info(mydata.orElse(none)); //자료가 없으면 "없음"으로 나오게.
	}

}
