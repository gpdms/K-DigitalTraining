package com.study.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.jdbc.Board;
import com.study.springboot.jdbc.BoardMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {
	
	final BoardMapper boardMapper; //생성자 만들어서 얘한테 객체 주입해주는것
	
	@GetMapping("/test1")
	public void ex1(Model mm, String writer, HttpSession ses) { //void로 하면 test1.html을 찾음.
		//templates에 있는 것은 .html로 요청 안됨.static에 있는 index는 index.html로 요청됨.
		
		List<Board> list = boardMapper.findAll(writer);
		mm.addAttribute("ddd", list); //그냥쓰면 null뜸. requiredArgsConstructor써주고 final. autowired같은 효과.
		ses.setAttribute("user","admin"); //세션 set
	}
	
	@GetMapping("/test2")
	public String ex2(Model ss, HttpSession ses) { //String으로 하면 return에 있는 파일명.html찾음.
		List<Board> list = boardMapper.findAll(null);
		ss.addAttribute("ddd", list);
		String user = (String) ses.getAttribute("user"); //세션 get
		log.info("---------------------사용자:"+user);
		return "test1";
	}
}
