package com.study.springboot.controller;

import com.study.springboot.dto.GradeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String hello(String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @PostMapping("/review")
    public ResponseEntity<Long> review(@RequestBody GradeDto gradeDto) {
        System.out.println("==========>"+gradeDto);
        return new ResponseEntity<>(gradeDto.getId(), HttpStatus.OK);
    }

    @GetMapping("/now")
    public String now(){
        return "now";
    }

    @GetMapping("/use")
    public String useHeader(Model model)   {
        model.addAttribute("aaa", "연습제목입니다");
        return "useHeader";
    }

    @GetMapping("/testPage")
    public String testPage(){
        return "testPage";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "hello2";
    }
}
