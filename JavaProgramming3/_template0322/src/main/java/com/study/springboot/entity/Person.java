package com.study.springboot.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString (exclude = "recList")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String addr;
    private Integer age;

    @OneToMany (mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rec> recList = new ArrayList<>();
}
