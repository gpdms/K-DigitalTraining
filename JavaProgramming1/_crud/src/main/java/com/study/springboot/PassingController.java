package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PassingController {

	@PostMapping("/test")
	public void test(User str) {
		log.info(str);
	}
}
