package com.study.springboot.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long did;
	private String title;
	private String content;
	private int idx;
	
	//@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	private Genre genre;

}
