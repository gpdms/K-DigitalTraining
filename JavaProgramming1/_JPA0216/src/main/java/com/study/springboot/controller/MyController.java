package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.springboot.entity.MyData;
import com.study.springboot.repository.MyDataRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor //final 생성자 만들어서 autowired해줌.
public class MyController {

	@Autowired //객체생성
	private final MyDataRepository myDataRepository;
	
	@GetMapping("/") //이게 생기면 index.html로 안감.
	public String list(Model model) {
		List<MyData> list = myDataRepository.findAll();
		model.addAttribute("list", list);
		return "view/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) { //PathVariable:url에 있는 값을 변수로 쓰겠다.
		Optional<MyData> myData = myDataRepository.findById(id); //Optional: null체크.
		log.info("--->"+myData);
		if(myData.isPresent()) {
			model.addAttribute("myData", myData.get().getMemo());
		} else { //null이면
			model.addAttribute("myData", "없음");
		}
		
		return "view/edit";
		
		
	}
	
	//@PostConstruct //요청받는거랑 상관없음. 재구동될때마다 얘가실행됨.  
	//의존성 주입이 이루어진 후 초기화를 수행하는 메서드이다. 다른 리소스에서 호출되지 않아도 수행된다. 
	public void init() {
		log.info("----여기요-----");
		//MyData d1 = new MyData(); //대신에 builder패턴
		MyData d1 = MyData.builder()
				.name("김")
				.age(34)
				.mail("kim@test.co.kr")
				.memo("이것은 kim의 자료")
				.build();
		log.info(d1);
		
		myDataRepository.saveAndFlush(d1); //insert. flush변화를 바로 적용시킨다. save()도 상관없음.
	}
}
