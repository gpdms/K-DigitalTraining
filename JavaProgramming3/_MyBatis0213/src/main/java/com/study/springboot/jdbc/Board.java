package com.study.springboot.jdbc;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Board {
	private int num;
	private String writer;
	private String title;
	private String content;
}
