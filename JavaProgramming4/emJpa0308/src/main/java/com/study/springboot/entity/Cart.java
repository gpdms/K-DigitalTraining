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
@ToString (exclude = "products")
public class Cart {
    //필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (mappedBy = "cart", cascade = CascadeType.MERGE) //mappedBy클래스이름 소문자로 일단 넣어주기. 그리고 manytoone에다가 필드로 넣으면됨.
    private List<Product> products = new ArrayList<>();



    //메소드
    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() { //메소드명 get을 붙이면 필드가 없어도 get가능. cart.totalPrice로 호출가능.
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
//    public String getTest() {
//        String str ="getTest:메소드명 get을 붙이면 필드가 없어도 get가능.";
//        return str;
//    }

}