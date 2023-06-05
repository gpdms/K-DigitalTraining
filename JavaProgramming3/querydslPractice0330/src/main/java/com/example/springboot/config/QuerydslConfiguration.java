package com.example.springboot.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//Querydsl은 "Query Domain Specific Language"의 약자
//데이터베이스 쿼리를 작성하기 위한 도메인 특화 언어(DSL)를 지원하는 프레임워크
@Configuration
public class QuerydslConfiguration {
    @PersistenceContext
    EntityManager em;

    @Bean //매번 new객체생성 안하도록 빈으로 등록.
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em);
    }
}
