package com.study.springboot.controller;

import com.study.springboot.dto.UploadResultDTO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class MyController {

    //설정 파일(properties파일) 등의 외부 자원에서 값을 읽어와 필드에 주입
    @Value("${file.dir}")
    private String uploadPath;

    @GetMapping("/uploadEx")
    public void uploadEx(){ //void로 하면 요청명이랑 똑같은 html파일을 반환.
        log.info("처음");
    }

    @PostMapping("/uploadAjax")
    public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles) throws IOException {

        List<UploadResultDTO> resultDTOList = new ArrayList<>();

        for(MultipartFile uploadFile: uploadFiles){
            //파일의 MIME 타입을 체크하여, 이미지 파일인지 여부를 확인하는 코드
            if(uploadFile.getContentType().startsWith("image")==false) {
                log.warn("this file is not image type");
                //클라이언트가 서버에게 요청한 작업을 수행할 권한이 없음을 나타내는 상태코드
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            String originalName = uploadFile.getOriginalFilename();
            log.info("originalName:"+originalName);
            String fileName = originalName.substring(originalName.lastIndexOf("\\")+1);
            log.info("fileName:"+fileName);
            //UUID를 생성하기 위한 메서드
            //UUID는 128비트 숫자로 이루어진 고유한 식별자
            String uuid = UUID.randomUUID().toString();
            String saveName = uuid+"_"+fileName;
            Path savePath = Paths.get(uploadPath+ File.separator + saveName);  //Path 임포트:java.nio.file.Path
                                                            //윈도우, 맥에서 경로 슬래시가 다르므로 separator를 써주는게 좋음.
            //원본저장
            uploadFile.transferTo(savePath); //throws 예외처리.
            //썸네일 생성
            String thumbnailName = uploadPath+File.separator+"s_"+uuid+"_"+fileName;
            File thumbnailFile = new File(thumbnailName);
            //썸네일 생성 라이브러리인 "Thumbnailator"를 사용하여 이미지 파일의 썸네일을 생성하는 메서드
            Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100); //100*100썸네일 만듦.
            resultDTOList.add(new UploadResultDTO(fileName, uuid));
            log.info(resultDTOList.toString());

        }
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }

    //업로드한 사진 썸네일 보이기
    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName) {
        log.info("*****fileName:"+fileName);
        //HTTP 응답을 생성할 때 사용되는 객체 중 하나인 ResponseEntity를 사용하여 byte 배열 형태의 데이터를 응답 본문으로 전송
        ResponseEntity<byte[]>result = null;

        try {
        //URL에서 인코딩된 문자열을 디코딩하여 원래의 문자열을 복원
        String srcFileName = URLDecoder.decode(fileName, "UTF-8"); //.decode예외처리
        log.info("----fileName:"+srcFileName);
        //new File(): 파일이나 디렉토리를 추상화한 클래스
        //File.separator: 파일 또는 디렉토리의 경로, 크기, 수정일자 등의 속성정보를 제공
        //파일 시스템 경로를 구분하는 문자열 사용
        //운영체제에 따라 파일 경로를 구분하는 구분자가 다르기 때문에
        File file = new File(uploadPath+File.separator+srcFileName);
        log.info("-----file: "+fileName);

        //HttpHeaders 객체를 생성하여 HTTP 요청 또는 응답의 헤더 정보를 설정하거나 읽어들일 수 있음
        HttpHeaders header = new HttpHeaders();
        //MIME타입 처리
        //파일의 MIME 타입을 추론
        //MIME 타입: 인터넷 상에서 파일의 형식을 지정하는 미디어 타입
        //"text/plain"은 일반 텍스트 파일, "image/jpeg"는 jpeg이미지 파일
        header.add("Content-Type", Files.probeContentType(file.toPath()));

        //HTTP 요청 또는 응답에 대한 응답 본문과 HTTP 상태코드, 헤더 등을 포함하는 클래스
        //파일데이터 처리: 파일의 내용을 바이트 배열로 읽어오는 메소드

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            //서버에서 내부적으로 오류가 발생했음을 나타내는 상태코드
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
    
    //remove버튼 누르면 썸네일 사진 삭제
    @PostMapping("/removeFile")
    public ResponseEntity<Boolean> removeFile(String fileName){
        
        String srcFileName = null;

        try {
            srcFileName = URLDecoder.decode(fileName, "utf-8"); //.decode: 예외처리 try catch
            File file = new File(uploadPath + File.separator+srcFileName);

            //delete() 메소드는 java.io.File 클래스의 메소드
            //이 메소드는 파일이 정상적으로 삭제되었을 경우 true를 반환하며,
            //삭제되지 않았을 경우 false를 반환
            boolean result = file.delete();
            //file.getParent() 메서드는 파일의 부모 디렉토리를 나타내는 문자열을 반환
            File thumbnail = new File(file.getParent(), "s_" +file.getName());
            result = thumbnail.delete();
            return new ResponseEntity<>(result, HttpStatus.OK);
            
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
