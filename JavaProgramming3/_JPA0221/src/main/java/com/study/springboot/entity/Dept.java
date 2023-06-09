package com.study.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
}
