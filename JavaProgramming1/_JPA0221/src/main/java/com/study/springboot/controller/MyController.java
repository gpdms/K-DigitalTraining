package com.study.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Master;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.MasterRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {

	private final EmpRepository empRepository;
	private final EmpDeptMapper empDeptMapper;
	private final MasterRepository masterRepository;
	
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
	
	@GetMapping("/listMaster")
	public String listMaster(Model model) {
		List<Master> list = masterRepository.findAll();
		model.addAttribute("list", list);
		return "/view/listMaster";
	}
	
}
