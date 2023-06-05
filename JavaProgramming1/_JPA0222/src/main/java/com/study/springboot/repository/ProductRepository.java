package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
