package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{

}
