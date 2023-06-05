package com.study.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
}
