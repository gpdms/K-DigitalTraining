package com.study.springboot.repository;

import com.study.springboot.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;

    //----------insert
    @Test
    public void testIns() {
//        Person person = Person.builder().name("홍길동").addr("서울").build();
//        personRepository.save(person);
//        Person person2 = Person.builder().name("김남준").addr("일산").build();
//        Person person3 = Person.builder().name("김석진").addr("경기").build();
//        Person person4 = Person.builder().name("민윤기").addr("대구").build();
//        Person person5 = Person.builder().name("정호석").addr("광주").build();
//        List<Person> personList = Arrays.asList(person2, person3, person4, person5);
//        personRepository.saveAll(personList);

        IntStream.rangeClosed(1,10).forEach(t->{
            Person person = Person.builder().name("이름"+t).addr("주소"+t).build();
            System.out.println(person);
            personRepository.save(person);
        });
    }

    //-------select-------------------
    @Transactional
    @Test
    public void testSel(){
        Person person = personRepository.getOne(1L);
        System.out.println(person);
    }

    @Test
    public void testSel2(){
        //Optional<Person> person = personRepository.findById(0L); //findById: 타입 Optional임. null exception 안뜨고 .empty()뜸
        //Optional안쓰고 편하게쓰려면 던지기. exception뜸.
        //Person person = personRepository.findById(0L).orElseThrow();
        Person person = personRepository.findById(1L).orElseThrow();
        System.out.println(person);
        List<Person> list = personRepository.findAll();
        list.stream().forEach(i->{
            System.out.print(i);
        });
    }

    //-------update----------------
    @Test
    public void testUpd(){
        Person person = Person.builder().pid(1L).name("김갑돌").addr("마포구").build();
                //insert할때는 pid안썼지만, update할때는 pid사용.
        personRepository.save(person);
        //내부적으로 select먼저함. 그다음 update.
    }

    //--------delete---------------
    @Test
    public void testDel(){
        personRepository.deleteById(1L);
    }


    //----JPQL---------------------------------
    @Test
    public void testSel3(){
//        Person person = personRepository.findPersonByName("김남준");
//        System.out.println(person);

//        List<Person> list = personRepository.findPersonByNameLike("%름%");
//        list.stream().forEach(t->{
//            System.out.println(t);
//        });

        List<Person> list = personRepository.findPersonByNameLikeOrderByPidDesc("%름%");
        list.stream().forEach(t->{
            System.out.println(t);
        });
    }

    @Test
    public void testSel4(){
        List<Person> list = personRepository.selectAll();
        list.stream().forEach(r->{
            System.out.println(r);
        });
    }

    @Test
    public void testSel5(){
        List<Person> list = personRepository.selectName("름");
        list.stream().forEach(r->{
            System.out.println(r);
        });
    }

    @Test
    public void insert1(){
        personRepository.insertPerson("연습이름","연습주소");
    }

    @Test
    public void insert2(){
        Person person = Person.builder().name("홍길순").addr("송도").build();
        personRepository.insertPerson2(person);
    }


}