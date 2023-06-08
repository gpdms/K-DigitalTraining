package com.study.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "movieList")
@Builder
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;
	private String genreName;
	

	@OneToMany(fetch = FetchType.LAZY,
	mappedBy = "genre", 
	cascade = CascadeType.ALL)
	private List<Movie> movieList = new ArrayList<>();
	
}
