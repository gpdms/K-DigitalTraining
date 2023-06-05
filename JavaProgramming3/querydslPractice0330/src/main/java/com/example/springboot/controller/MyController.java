package com.example.springboot.controller;

import com.example.springboot.entity.Emp;
import com.example.springboot.entity.QEmp;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final JPAQueryFactory jpaQueryFactory; //config파일에 bean등록했기때문에

    @GetMapping("/test")
    @ResponseBody
    public List<Emp> test(){
        QEmp emp = QEmp.emp;
        List<Emp> list = jpaQueryFactory.selectFrom(emp).fetch();
        System.out.println(list);
        return list;
    }
}
