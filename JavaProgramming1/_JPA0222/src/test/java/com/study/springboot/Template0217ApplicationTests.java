package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.entity.Emp;
import com.study.springboot.entity.Product;
import com.study.springboot.entity.ProductDetail;
import com.study.springboot.jdbc.EmpDeptMapper;
import com.study.springboot.repository.EmpRepository;
import com.study.springboot.repository.ProductDetailRepository;
import com.study.springboot.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Template0217ApplicationTests {

	@Autowired
	EmpDeptMapper empDeptMapper;
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductDetailRepository productDetailRepository;
	
	
	@Disabled
	@Test
	public void testMyBatisFindAllEmp() {
		List<Emp> list 
		= empDeptMapper.findAllEmp("78", "S");
		log.info(list);
	}
	
	//insert
	@Disabled
	@Test
	public void testInsProduct() {
		Product product = Product.builder().name("책2").price(30000).stock(10).build();
		ProductDetail pd = ProductDetail.builder().content("매우 좋은 책22").build();
//		product.setProductDetail(pd);
//		productRepository.save(product);
		pd.setProduct(product);
		productDetailRepository.save(pd);
	}
	
	//select
	@Test
	public void testSelectProduct() {
		Product product = productRepository.findById(2L).orElseThrow(); //pk가 2인 자료를 뜻함.L은 Long이라서.
		log.info(product);
		log.info(product.getProductDetail());
	}

}
