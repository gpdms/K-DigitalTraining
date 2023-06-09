package com.study.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long mno;
		private String title;
		@OneToMany(fetch = FetchType.LAZY, 
					mappedBy = "movie",
					cascade = CascadeType.ALL) //mappedBy 내가 주인. cascade:Movie에 한건추가하면, poster에도 추가.
		private List<Poster> posterList = new ArrayList<>();
}
