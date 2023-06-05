package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Master;

//데이터베이스에 접근하는 메소드를 repository에서 관리
public interface MasterRepository extends JpaRepository<Master, Long>{

}
