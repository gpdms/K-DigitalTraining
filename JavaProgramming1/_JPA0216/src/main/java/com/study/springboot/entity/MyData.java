package com.study.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="mydata")//테이블명을 바꾸고싶은 경우.
@Builder //생성자가 생김.객체생성없이 사용하기 위해 사용. 
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyData {
	@Id //primary key. 컬럼명 id와는 상관없음.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//mysql, mariadb, h2는 identity로하면 auto_increment의 효과. 오라클은 sequence.
	private long id; //Long, long둘다 가능. long타입의 id컬럼을 생성.
	
	@Column(length = 50, nullable = false)//varchar(50), not null
	private String name;
	
	@Column(length = 200, nullable = true)
	private String mail;
	private int age; //Integer, int 둘다 가능.
	@Column (nullable= true)
	private String memo;
	
}
