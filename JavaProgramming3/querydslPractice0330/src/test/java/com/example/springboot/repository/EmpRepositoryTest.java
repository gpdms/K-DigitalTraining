package com.example.springboot.repository;

import com.example.springboot.entity.Emp;
import com.example.springboot.entity.QEmp;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpRepositoryTest {

    private JPAQueryFactory jpaQueryFactory;

    @PersistenceContext
    EntityManager em;

    @Test
    public void test1(){
        QEmp emp = QEmp.emp; //build폴더 밑에 QEmp
        jpaQueryFactory = new JPAQueryFactory(em); //테스트라 생성
//        List<Emp> list = jpaQueryFactory.selectFrom(emp).fetch();
        //Emp타입이면 null안들어감. (comm이 int로 되어 있으면. Integer면 들어감.)

        List<Tuple> list = jpaQueryFactory
                .select(emp.ename, emp.job, emp.sal)
                .from(emp)
                .fetch();
        //Tuple로하면 null들어감.

        list.stream().forEach(t->{
            System.out.println(t);
        });
    }

    @Test
    public void test2(){
        QEmp emp = QEmp.emp;
        jpaQueryFactory = new JPAQueryFactory(em);
        String ename = "%A%";
        String empno = "7%";
        BooleanBuilder builder = new BooleanBuilder(); //where뒤의 조건을 생성해주는 것
        if(ename != null){
            builder.and(emp.ename.like(ename));
        }
        if (empno != null){
            builder.or(emp.empno.like(empno));
        }
        List<Tuple> list = jpaQueryFactory
                .select(emp.empno, emp.ename, emp.job, emp.sal, emp.comm.coalesce(0).as("comm")) //null을 0으로처리.
                .from(emp)
                .where(builder)
                .fetch();
        list.stream().forEach(t->{
            System.out.println(t);
        });
    }


    @Test
    public void test3(){
        QEmp emp = QEmp.emp;
        jpaQueryFactory = new JPAQueryFactory(em);

        List<Long> count = jpaQueryFactory.select(Wildcard.count).from(emp).fetch();
        System.out.println("---------------count: "+count.get(0));

        JPAQuery<Long> query = jpaQueryFactory.select(Wildcard.count).from(emp);
        Long result = query.fetchOne();
        System.out.println("-----------JPAQuery<Long>:"+ result);
    }






}