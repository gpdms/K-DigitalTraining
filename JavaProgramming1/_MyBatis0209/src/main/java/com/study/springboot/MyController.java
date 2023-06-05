package com.study.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor //의존성주입4번째. 생성자주입과 비슷. final 써주면 autowired안써도됨.
@RequestMapping("/ex/*")
public class MyController {

	private final EmpDao empDao;
	
	@GetMapping("/ex1")
	public void ex1() {
		log.info("/ex1.....................");
	}
	@GetMapping("/ex2")
	public void ex2(Model model) {
		List<String> strList = IntStream.range(1, 10)
				.mapToObj(i->"Data"+i)
				.collect(Collectors.toList());
		log.info("----------"+strList);
		Map<String, String> map = new HashMap<>();
		map.put("A", "AAA");
		map.put("B", "BBB");
		model.addAttribute("map", map);
		model.addAttribute("list", strList);
	}
	
	@GetMapping("/ex3")
	public void ex3(Emp emp) {
		int res = empDao.write(emp);
		log.info("................."+res);
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		List<Emp> list = empDao.list();
		log.info("...............리스트");
		model.addAttribute("list", list);
	}
	
	@PostMapping("/update")
	public String update1(Emp emp) {
		empDao.update(emp);
		return "redirect:/ex/list";

	}
	
	@GetMapping("/update")
	public void update(int empno, Model model) {
		Emp emp = empDao.viewOne(empno);
		model.addAttribute("emp", emp);
	}
	
	@GetMapping("/ex4")
	public void ex4(Model model) {
		model.addAttribute("arr", new String[] {"AA","BB","CC"});
	}
}





