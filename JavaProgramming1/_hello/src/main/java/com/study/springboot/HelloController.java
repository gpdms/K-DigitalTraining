package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/") //요청: 웹사이트가 열리면 //webservlet과 비슷
	public String aaa(Model model) { //import-spring선택
		model.addAttribute("msg", "Test"); //request기본객체와 비슷
		return "index";
	}
	
	@RequestMapping("/{num}")
	public ModelAndView index (@PathVariable int num, ModelAndView mav) {
		int res = 0;
		for(int i = 1; i <= num; i++)
			res += i;
		mav.addObject("msg", "total: "+ res);
		mav.setViewName("test");
		return mav;
	}
	
//	@GetMapping("/now") //웹브라우저 url에 /now 적기
//	public String bbb() {
//		return "test";
//	}
	
	
}
