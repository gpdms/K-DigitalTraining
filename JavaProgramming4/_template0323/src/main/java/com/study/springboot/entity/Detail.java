package com.study.springboot.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
public class Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long did;
	private String title;
	private String content;
	private Integer idx;

	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Genre genre;
}
