package com.study.springboot.controller;

import com.study.springboot.dao.EmpMapper;
import com.study.springboot.dto.Emp;
import com.study.springboot.entity.TestEntityManager;
import com.study.springboot.jdbc.EmpDeptMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor //반드시 쓰기. @Autowired안씀.
@Slf4j
public class MyController {
    private final EmpMapper empMapper;
    private final TestEntityManager testEntityManager;
    private final EmpDeptMapper empDeptMapper;

    @GetMapping("/empList")
    public String hello(Model model) {
        System.out.println(empMapper.findAll());
        model.addAttribute("list", empMapper.findAll());
        return "empList";
    }

    @GetMapping("/testEm")
    @ResponseBody
    public String testEm() {
        testEntityManager.personCreate();
        testEntityManager.personSelect();
        return "OK";
    }

    @GetMapping("/")
    public String root() {
        return "view/index";
    }

    @GetMapping("/list")
    public String listEmp(Model model) {
        // List<Emp> list = empRepository.findAll();
        List<Emp> list = empDeptMapper.findAllEmp("%", "A");
        model.addAttribute("list", list);
        return "view/list";
    }

    @GetMapping("/search")
    public String search(Model model, String search, String type) {
        log.info("---search:" + search + ", type:" + type);
        List<Emp> list = empDeptMapper.findAllEmp(search, type);
        model.addAttribute("list", list);
        return "view/list";
    }

}
