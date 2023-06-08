package com.study.springboot.repository;

import com.study.springboot.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeRepositoryTest {
    @Autowired
    NoticeRepository noticeRepository;

    @Test
    public void testIns(){
        Long seq = noticeRepository.selectMaxSeq();
        Notice notice = Notice.builder().seq(seq+10000L).title("제목1").content("내용1").build();
        noticeRepository.insertNotice(notice);
        //noticeRepository.flush();//commit같은. 비우는 것.
        //noticeRepository.saveAndFlush(notice);


    }

}