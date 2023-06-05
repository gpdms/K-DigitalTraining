package com.study.springboot.repository;

import com.study.springboot.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository //extends안하면 반드시 붙여야. extends하면 붙여도 안붙여도ㅇ
public interface NoticeRepository extends JpaRepository<Notice, Long> {
//인터페이스명에 오른쪽마우스 go to - test

    @Transactional
    @Modifying
    @Query(value = "insert into notice(seq, title, content, parent) " +
            "values (:#{#notice.seq}, :#{#notice.title}, :#{#notice.content}, :#{#notice.parent})", nativeQuery = true)
    public void insertNotice(@Param("notice") Notice notice);//insert의 경우 return타입은 void, int만.

    @Query(value = "select max(seq) from notice", nativeQuery = true)
    public Long selectMaxSeq();

    @Query(value = "select * from notice order by seq desc", nativeQuery = true)
    public List<Notice> selectOrderSeq();

    //위에 것 대신에 기본메소드 활용
    public List<Notice> findAllByOrderBySeqDesc();




}
