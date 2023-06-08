package com.study.springboot.controller;

import java.util.List;

import com.study.springboot.entity.Genre;
import com.study.springboot.entity.Movie;
import com.study.springboot.repository.GenreRepository;
import com.study.springboot.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MyController {

	//private final Movie movie;
	//private final Genre genre;
	private final GenreRepository genreRepository;
	private final MovieRepository movieRepository;
	
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
		List<Genre> genreList = genreRepository.findAll();
		//System.out.println("genreList--------"+genreList);
		log.info("genreList--------"+genreList);
		model.addAttribute("genreList", genreList);
		return "view/admin";
	}


	@PostMapping("/insert")
	public String insertMovie(Movie movie){
		System.out.println("----form으로 받아온 정보-------");
		System.out.println(movie);
		Genre movieGenre = movie.getGenre();
		int size = movieGenre.getMovieList().size();
		movie.setIdx(size);
		System.out.println("setidx이후---------:");
		System.out.println(movie);
		movieRepository.save(movie);
		return "redirect:/admin";
	}



}
