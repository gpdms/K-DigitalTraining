package com.study.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.springboot.entity.Cart;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString (exclude = "cart")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;

    @ManyToOne
    @JsonIgnore //안붙이면 StackOverflowError뜸.
    private Cart cart; //mappedBy 명.
}