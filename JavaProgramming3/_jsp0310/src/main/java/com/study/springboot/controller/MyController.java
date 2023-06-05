package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String root(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(String name, Model model){
        model.addAttribute("name", name);
        return "hello2";
    }
}
