package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/test/test")//void타입: 이 위치로 찾아감.
	public void test1(Model md) { //html에 값넘겨줄때 Model.포워딩됨.Model에 객체를 넣어줄 수 있다.
		md.addAttribute("ttt", "1234");
		md.addAttribute("yyy", "abcd");

	}
	
	@GetMapping("/aaa")
	public String aaa1(int ee, String ff, Model model) {
		model.addAttribute("ss", ee);
		model.addAttribute("ss2", ff);
		
		return "/test/result"; //String타입: 이 문자열로 찾아감.
	}
}
