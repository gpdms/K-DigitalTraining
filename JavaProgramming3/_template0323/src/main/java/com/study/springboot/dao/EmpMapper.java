package com.study.springboot.dao;

import com.study.springboot.dto.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from emp")
    List<Emp> findAll();
}
