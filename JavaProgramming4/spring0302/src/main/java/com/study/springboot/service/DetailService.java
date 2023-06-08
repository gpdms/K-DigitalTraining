package com.study.springboot.service;

import com.study.springboot.entity.Notice;

public interface DetailService { //인터페이스니까 구현하는 애 필요.
    Notice detail(Long seq); //리턴타입, 메소드명
}
