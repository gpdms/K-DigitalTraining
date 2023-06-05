package com.study.springboot.controller

import com.study.springboot.entity.Dept
import com.study.springboot.repository.DeptRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MyController(private val deptRepository: DeptRepository) {

//    @Autowired
//    lateinit var deptRepository: DeptRepository

    @GetMapping("/")
    fun root(model: Model): String {
        model.addAttribute("name", "세상")
        return "index"
    }

    @GetMapping("/dept")
    fun dept(model: Model): String? {
        val list: List<Dept?> = deptRepository.findAll() ?: emptyList()
        println(list)
        model.addAttribute("list",list)
        return "dept"
    }

}