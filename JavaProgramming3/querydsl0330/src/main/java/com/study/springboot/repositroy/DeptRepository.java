package com.study.springboot.repositroy;

import com.study.springboot.entity.Dept;
import com.study.springboot.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

    @Query("select e from Emp e inner join Dept d on e.deptno=d.deptno where e.deptno = :id")
    List<Emp> findByWithDept(@Param("id") Integer id);
}
