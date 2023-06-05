package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MyFilter0206Application {

	public static void main(String[] args) {
		SpringApplication.run(MyFilter0206Application.class, args);
	}

}
