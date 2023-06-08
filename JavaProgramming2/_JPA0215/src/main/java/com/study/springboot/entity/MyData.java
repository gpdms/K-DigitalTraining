package com.study.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //테이블이라고 생각하면 됨.
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyData { //이 이름으로 데이터베이스에 my_data 테이블이 만들어짐.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private Long id; 
	private String memo;
	//private String numContent; //컬럼추가하면 alter됨. num_content열이 들어감
	//application.properties에서 create-drop하면 테이블 드랍하고 생성함.
}
