package com.study.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.springboot.entity.Movie;
import com.study.springboot.entity.Genre;
import com.study.springboot.jdbc.GenreDetailMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {
	
	
	@GetMapping("/")
	public String root() {
		return "view/firstpage";
	}
	
	@GetMapping("/actionList")
	public String action() {
		return "view/action";
	}
	
	@GetMapping("/movie/{genre}")
	public String movie(@PathVariable("genre") String genre, Model model) {
		if(genre.equals("action")) {
		
			return "view/action";
		}else if(genre.equals("family")) {
			return "view/family";
		}else if(genre.equals("comic")) {
			return "view/comic";
		}else if(genre.equals("horror")) {
			return "view/horror";
		}else if(genre.equals("scienceFiction")) {
			return "view/scienceFiction";
		}else {
			return "/";
		}
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
	
		
		return "view/admin";
	}
	
}
