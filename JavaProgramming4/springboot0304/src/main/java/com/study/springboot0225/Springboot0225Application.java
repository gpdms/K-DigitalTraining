package com.study.springboot0225;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Springboot0225Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot0225Application.class, args);
	}

	@Autowired
	EntityManager entityManagement;

	@GetMapping(value = "/em")
	public void entityManagement() {
		entityManagement.personCreate();
		entityManagement.personSelect();
		//entityManagement.userRemove();
	}

}
