package com.study.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document //몽고db는 Entity 대신 Document로. 스프링부트에서는 Document생략가능하지만 붙임.
public class MyDataMongo {
    @Id
    private String id; //몽고db는 Long타입 주면 안됨.
    private String name;
    private String memo;
    private Date date;

    public MyDataMongo(String name, String memo) {
        super();
        this.name = name;
        this.memo = memo;
        this.date = new Date();


    }
}
