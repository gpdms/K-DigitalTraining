package com.study.springboot.repository;

import com.study.springboot.dto.MyDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo,Long> { //dto엔String, 여기엔 Long.왜지???
    //JpaRepository랑 MongoRepository 차이?
    //MongoRepository는 mongoDB에 특화된 repository이다.
    //JPARepository and MongoRepository are technology-specific abstraction of the Spring Data Repositories.
    //If you are using RDBMS such as MySQL/PostgreSQL, you may use Spring Data Repositories such as JpaRepository.
    // If using a NoSQL such as Mongo, you will need the MongoReposiroty.


    public List<MyDataMongo> findByName(String s);
    public List<MyDataMongo> findByNameLike(String s); //like 와일드카드

}
