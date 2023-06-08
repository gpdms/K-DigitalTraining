package com.study.springboot;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller //어노테이션 잊지말기!
public class MyController {
	@Autowired
	private EmpMapper empMapper;
			//인터페이스만든것
	
	@GetMapping("/now") //요청명. url에 입력하는것.
	public String asfd() {
		return "root"; //root.html파일을 의미.
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Emp> elst = empMapper.findAll();
		//콘솔에서 확인
//		for (Emp emp : elst) {
//			System.out.println(emp.getEname());
//		}
		model.addAttribute("list", elst);
		return "list";
	}
	
	@PostMapping("/insert")
	public String insert (Emp emp, Model model) {
		int res = empMapper.save(emp);
		
		return "redirect:/list"; //redirect는 res값 못넘겨줌. forward는 값넘겨줌.
	}
	
	@GetMapping("/delete")
	public String delete(int empno) {
		empMapper.delete(empno);
		return "redirect:/list";
	}
	
	@PostMapping("/upload3")
	@ResponseBody
	public void FileUpload3(MultipartHttpServletRequest request) {
	try {
		System.out.println("/upload3");
		String test = request.getParameter("test");
		System.out.println(test);
		MultipartFile file = request.getFile("file");
		System.out.println(file.getOriginalFilename());
		
		//File 경로 임의 지정
		String uploadPath = "C:\\upload/test/abc/";
		
		File fileUpload = new File(uploadPath, file.getOriginalFilename());
		
		//생성 될 경로가 없을 경우, 파일을 생성한다.
		if (!fileUpload.exists()) {
			System.out.println(uploadPath + ":파일 경로 생성완료");
			fileUpload.mkdirs();
		} 
		file.transferTo(fileUpload);
	} catch (Exception e) {
		
	}
	}
	
}
