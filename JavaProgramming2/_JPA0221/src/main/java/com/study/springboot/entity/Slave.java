package com.study.springboot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "master")
@Entity
public class Slave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private String title;
	private String content;
	private int idx; //순번
	
	@ManyToOne(fetch = FetchType.LAZY) //자기가 여러개고 마스터가 하나.
	private Master master; //연관관계맺어줌. 변수:객체를 가리키는 포인터라고 생각해.
	//양방향으로 세팅해줘야. 여기에 했으면 master에도 세팅해줘야.
}
