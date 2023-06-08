package com.study.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;
	private String gname;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genre", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Detail> dList = new ArrayList<>();
	
	public void addDetail(Detail detail) {
		detail.setIdx(this.dList.size());
		detail.setGenre(this);
		dList.add(detail);
	}
}
