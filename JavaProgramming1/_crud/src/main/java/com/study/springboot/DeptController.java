package com.study.springboot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/view/*")

public class DeptController {
	private final DeptDao deptdao;
	
	@GetMapping("/list")
	public void list(Model model) {
		List<Dept>list =deptdao.selectAll();
		log.info("..........리스트..........");
		model.addAttribute("list", list);
	}
	@GetMapping("/update")
	public void update(int deptno, Model model) {
		Dept dept = deptdao.viewOne(deptno);
		model.addAttribute("dept",dept);
	}
	
	@PostMapping("/update")
	public String upload(Dept dept) {
		deptdao.update(dept);
		return "redirect:/view/list";
	}
}
	
