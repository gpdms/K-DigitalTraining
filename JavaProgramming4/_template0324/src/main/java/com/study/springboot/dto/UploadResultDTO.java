package com.study.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
//직렬화(serialization) 기능을 사용하기 위해 구현
//직렬화란, 객체를 바이트 형태로 변환하여 파일이나 네트워크를 통해
//전송하거나 저장하는 과정
//객체를 쉽게 전송하거나 저장, 분산 시스템에서 객체를 주고받을 때 유용
public class UploadResultDTO implements Serializable {
    private String fileName;
    private String uuid;

    public String getImageURL() throws UnsupportedEncodingException {
        //URL을 인코딩하는 과정은 특수문자나 한글 등의 문자를 URL에서
        //사용할 수 있는 형식으로 변환
        //URL에서 사용할 수 없는 특수문자 등이 "%XX" 형태로 변환되어 인코딩
        return URLEncoder.encode(uuid+"_"+fileName, "UTF-8");
    }

    public String getThumbnailURL(){
        try {
            return URLEncoder.encode("s_"+uuid+"_"+fileName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
