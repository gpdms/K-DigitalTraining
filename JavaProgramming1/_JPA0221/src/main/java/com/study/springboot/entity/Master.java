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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "slaveList")//얘는제외. 객체정보가져올때 얘때문에 에러날 수 있어서.
@Entity //데이터베이스 테이블을 가지고 있는 객체.
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mid;
	private String code;
	private String comment;
	
	@OneToMany(fetch = FetchType.EAGER,
				mappedBy = "master", //Slave의 컬럼 master임.
				cascade = CascadeType.ALL) 
	private List<Slave> slaveList = new ArrayList<>(); //비어있을뿐 null값이있진않음.
	
	//slaveList에 넣어주는 메소드
	public void addSlave(Slave slave) {
		slave.setIdx(this.slaveList.size());
		slave.setMaster(this); 
		slaveList.add(slave);
	}
}
