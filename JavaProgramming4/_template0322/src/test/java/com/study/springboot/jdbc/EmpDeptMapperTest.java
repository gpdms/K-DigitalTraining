package com.study.springboot.jdbc;

import com.study.springboot.dto.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmpDeptMapperTest {

    @Autowired
    EmpDeptMapper empDeptMapper;

    @Test
    public void test(){
        List<Dept> list = empDeptMapper.findAllDept();
        list.stream().forEach(t->{
            System.out.println(t);
        });
    }
}