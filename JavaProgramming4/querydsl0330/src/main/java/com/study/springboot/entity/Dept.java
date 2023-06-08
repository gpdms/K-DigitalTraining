package com.study.springboot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Dept {
    @Id
    private Integer deptno;
    private String dname;
    private String loc;

}
