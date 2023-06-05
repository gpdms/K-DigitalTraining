package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {
	@Autowired
	EmpMapper empMapper;
	
	@GetMapping("/list") //list:요청명
	public String list(Model model) { //list: 메소드 이름. Model: import해주기
		//데이터베이스 연동
		List<Emp> lst = empMapper.findAll();
		for (Emp emp: lst) {
			System.out.println(emp); //새로고침 후 콘솔창 확인.
		}
		model.addAttribute("list", lst);
		return "list"; //list: html 파일이름.
	}
	
	@GetMapping("/update") //폼을 불러오는 것.
	public String update(int empno, Model model) {
		Emp emp = empMapper.selectOne(empno);
		model.addAttribute("emp", emp); //"emp"객체. 얘를 아래 "update"에 넘겨줌forwarding.
		return "update";
	}
	
	@PostMapping("/update") //post로 오는. 동일한 /update요청명이어도 get과 post다르게 인식.
	public String update(Emp emp) {
		empMapper.update(emp);
		return "redirect:/list";
	}
	
}
