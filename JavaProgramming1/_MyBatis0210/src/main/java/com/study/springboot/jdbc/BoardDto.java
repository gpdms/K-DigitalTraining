package com.study.springboot.jdbc;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardDto {
	private int num;
	private String writer;
	private String title;
	private String content;
}
