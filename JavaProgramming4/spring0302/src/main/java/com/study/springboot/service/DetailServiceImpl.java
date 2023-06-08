package com.study.springboot.service;

import com.study.springboot.entity.Notice;
import com.study.springboot.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService{ //DetailService인터페이스를 구현

    private final NoticeRepository noticeRepository;

    @Override
    public Notice detail(Long seq) {
        Notice notice = noticeRepository.findById(seq).orElseThrow();
        return notice;
    }
}
