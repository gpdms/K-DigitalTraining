package com.study.springboot.repositroy;

import com.study.springboot.dto.Emp;
import com.study.springboot.entity.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {

}
