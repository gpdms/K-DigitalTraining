package com.study.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.springboot.entity.Emp;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {

	private final EmpRepository empRepository;
	private final EmpDeptMapper empDeptMapper;
	
	@GetMapping("/")
	public String root() {
		return "view/index";
	}
	
	@GetMapping("/list")
	public String ListEmp(Model model) {
		//List<Emp> list = empRepository.findAll();
		List<Emp> list = empDeptMapper.findAllEmp("%", "A");
		model.addAttribute("list", list);
		return "view/list";
	}
	
	@GetMapping("/search")
	public String search(Model model, String search, String type) {
		log.info("---search:"+search+", type:"+type);
		List<Emp> list = empDeptMapper.findAllEmp(search, type);
		model.addAttribute("list", list);
		return "view/list";
	}
	
	
	//페이징---------------------------
	@GetMapping("/page/{num}")
	public String page(@PathVariable int num, Model model) {
		Pageable pageable = PageRequest.of(num-1, 5); //현재페이지 0번페이지, 5개씩 끊겠다.
		Page<Emp> res = empRepository.findAll(pageable);
		log.info("total count:"+res.getTotalElements()); //총 레코드 수
		log.info("total page:"+res.getTotalPages()); //페이지가 몇개
		log.info("page number:"+res.getNumber());
		log.info("page size"+res.getSize()); //한페이지당 레코드 수
		res.stream().forEach(t->{
			log.info(t);
		});
		
		model.addAttribute("list", res);
		
		return "view/page";
	}
	
	//페이지번호 url에 안뜨게
	@GetMapping("/page2")
	public String page2(@PageableDefault(page=0, size=5) Pageable pageable, Model model) {
		Page<Emp> res = empRepository.findAll(pageable);
		model.addAttribute("list", res);
		return "view/page2";
	}
	
	@GetMapping("/test")
	public String test() {
		return "view/test";
	}
	
}
